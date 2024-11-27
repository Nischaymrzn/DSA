package Algorithms;
import java.util.*;

public class StackUsing2Queues {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            return q1.isEmpty();
        }

        // Push element onto the stack
        public void push(int data) {
            // Add the new element to q2
            q2.add(data);

            // Move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Swap the names of q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // Pop the top element from the stack
        public int pop() {
            if (q1.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return q1.remove();
        }

        // Peek the top element of the stack
        public int peek() {
            if (q1.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return q1.peek();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print and pop elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
