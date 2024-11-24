package Algorithms;
import java.util.Stack;

public class InfixToPostFix {
    int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    String convertToPostfix(String exp) {
        String res = "";
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(c)) {
                res += c;
            } 
            // Left Parenthesis
            else if (c == '(') {
                stk.push(c);
            } 
            // Right Parenthesis
            else if (c == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    res += stk.pop();
                }
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                } else {
                    throw new IllegalArgumentException("Invalid Expression");
                }
            } 
            // Operator
            else {
                while (!stk.isEmpty() && precedence(c) <= precedence(stk.peek())) {
                    res += stk.pop();
                }
                stk.push(c);
            }
        }

        // Pop remaining operators from the stack
        while (!stk.isEmpty()) {
            if (stk.peek() == '(') {
                throw new IllegalArgumentException("Invalid Expression");
            }
            res += stk.pop();
        }

        return res;
    }

    

    public static void main(String[] args) {
        InfixToPostFix converter = new InfixToPostFix();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Postfix: " + converter.convertToPostfix(infix));
    }
}
