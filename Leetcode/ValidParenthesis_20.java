package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class ValidParenthesis_20 {
    public boolean isValid(String s) {
        ArrayList<Character> stk = new ArrayList<>();

       // Iterate over each character in the string
       for (int i = 0; i < s.length(); i++) {
           char currentChar = s.charAt(i);
           
           // Check if the character is an opening bracket
           if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
               stk.add(currentChar); // Simulate push
           } 
           else {
               // If it's a closing bracket, check if the stack is non-empty
               // and if the top of the stack is a matching opening bracket
               if (!stk.isEmpty() && 
                   ((stk.get(stk.size() - 1) == '(' && currentChar == ')') ||
                    (stk.get(stk.size() - 1) == '{' && currentChar == '}') ||
                    (stk.get(stk.size() - 1) == '[' && currentChar == ']'))) {
                   stk.remove(stk.size() - 1); // Simulate pop
               }
               else {
                   return false;
               }
           }
       }

       // If stack is empty, return true (balanced), otherwise false
       return stk.isEmpty();
   }

   public boolean isValid_2(String s){
    Stack<Character> stk = new Stack<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '{' || ch == '[') {
            stk.push(ch);
        } else if ((ch == ')' && (stk.isEmpty() || stk.pop() != '(')) ||
                   (ch == '}' && (stk.isEmpty() || stk.pop() != '{')) ||
                   (ch == ']' && (stk.isEmpty() || stk.pop() != '['))) {
            return false;
        }
    }
    return stk.isEmpty();
}



    public static void main(String[] args) {
        ValidParenthesis_20 v=new ValidParenthesis_20();
        System.out.println(v.isValid_2("()({})"));
    }   
}

