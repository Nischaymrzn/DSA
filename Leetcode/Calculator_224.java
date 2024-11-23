package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator_224 {
    public int calculate(String s) {
        // Split input string into tokens, including operators and parentheses
        String[] expression = s.replaceAll(" ", "").split("(?<=[-+*/()])|(?=[-+*/()])");
        Stack<String> stk = new Stack<>();
        Stack<Integer> resStk = new Stack<>();
        ArrayList<String> tokens = new ArrayList<>();
        boolean isTrue = false;

        for (int i=0;i<expression.length;i++) {
            String c=expression[i];
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                // Handle operators
                if(c.equals("-")){
                    if (i == 0 || expression[i - 1].equals("(") || expression[i - 1].equals("+") || expression[i - 1].equals("-") || expression[i - 1].equals("*") || expression[i - 1].equals("/")){
                        tokens.add("0");
                    }
                }
                if (stk.isEmpty()) {
                    stk.push(c);
                } else {
                    String top = stk.peek();
                    if (c.equals("+") || c.equals("-")) {
                        while (!stk.isEmpty() && (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/"))) {
                            tokens.add(stk.pop());
                            if (!stk.isEmpty()) {
                                top = stk.peek();
                            }
                        }
                    } else if (c.equals("*") || c.equals("/")) {
                        while (!stk.isEmpty() && (top.equals("*") || top.equals("/"))) {
                            tokens.add(stk.pop());
                            if (!stk.isEmpty()) {
                                top = stk.peek();
                            }
                        }
                    }
                    stk.push(c);
                }
            } else if (c.equals("(")) {
                // Push opening parenthesis to stack
                stk.push(c);
            } else if (c.equals(")")) {
                // Pop stack until matching opening parenthesis
                while (!stk.isEmpty() && !stk.peek().equals("(")) {
                    tokens.add(stk.pop());
                }
                stk.pop(); // Remove the opening parenthesis
            } else {
                // Add numbers to tokens list
                tokens.add(c);
            }
        }

        // Pop remaining operators from stack
        while (!stk.isEmpty()) {
            tokens.add(stk.pop());
        }

        // Evaluate the postfix expression
        for (String token : tokens) {
            if (token.equals("+")) {
                int a = resStk.pop();
                int b = resStk.pop();
                resStk.push(b + a);
            } else if (token.equals("-")) {
                int a = resStk.pop();
                int b = resStk.pop();
                resStk.push(b - a);
                
            } else if (token.equals("*")) {
                int a = resStk.pop();
                int b = resStk.pop();
                resStk.push(b * a);
            } else if (token.equals("/")) {
                int a = resStk.pop();
                int b = resStk.pop();
                resStk.push(b / a);
            } else {
                // Parse the token as an integer
                resStk.push(Integer.parseInt(token.trim()));
            }
        }

        // Return the result from the stack
        return resStk.peek();
    }
    public static void main(String[] args){
        Calculator_224 newCal=new Calculator_224();
        int n=newCal.calculate("3-(-1-2)+2+2");
        System.out.println(n);

    }
    
}
