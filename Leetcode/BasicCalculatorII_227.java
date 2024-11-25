package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculatorII_227 {
    public int calculate(String s) {
        String[] expression = s.split("(?<=[-+*/])|(?=[-+*/])");
       
        Stack<String> stack = new Stack<>();
        Stack<Integer> resStack = new Stack<>();
        ArrayList<String> tokens = new ArrayList<>();
        
        // Infix to Postfix
        for (int i = 0; i < expression.length; i++) {
            
            String c = expression[i];
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    String top = stack.peek();
                    if (c.equals("+")) {
                        while (!stack.isEmpty()
                                && (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/"))) {
                            tokens.add(stack.pop());
                            if (!stack.isEmpty()) {
                                top = stack.peek();
                            }
                        }
                        stack.push(c);
                    } else if (c.equals("-")) {
                        while (!stack.isEmpty()
                                && (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/"))) {
                            tokens.add(stack.pop());
                            if (!stack.isEmpty()) {
                                top = stack.peek();
                            }
                        }
                        stack.push(c);
                    } else if (c.equals("*")) {
                        while (!stack.isEmpty() && (top.equals("*") || top.equals("/"))) {
                            tokens.add(stack.pop());
                            if (!stack.isEmpty()) {
                                top = stack.peek();
                            }
                        }
                        stack.push(c);
                    } else if (c.equals("/")) {
                        while (!stack.isEmpty() && (top.equals("*") || top.equals("/"))) {
                            tokens.add(stack.pop());
                            if (!stack.isEmpty()) {
                                top = stack.peek();
                            }
                        }
                        stack.push(c);
                    }
                }
            } else {
                if (!c.equals(" ")) {
                    tokens.add(c);
                }
            }

        }
        while (!stack.isEmpty()) {
            tokens.add(stack.pop());
        }

        // Evaluate Postfix
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int firstPopped = resStack.pop();
                int secondPopped = resStack.pop();

                if (token.equals("+"))
                    resStack.push(secondPopped + firstPopped);
                else if (token.equals("-"))
                    resStack.push(secondPopped - firstPopped);
                else if (token.equals("*"))
                    resStack.push(secondPopped * firstPopped);
                else if (token.equals("/"))
                    resStack.push(secondPopped / firstPopped);

            } else {
                resStack.push(Integer.parseInt(token.trim()));
            }
        }

        return resStack.peek();
    }


    public static void main(String[] args) {
        BasicCalculatorII_227 b=new BasicCalculatorII_227();
        System.out.println(b.calculate("2+2+2"));
        
    }
    
}

