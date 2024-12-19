package dataStructures;

//stack implementation from scratch
public class Stacks {
    int[] stk;
    int top;
    int size;

    Stacks(int size){
        this.size=size;
        top=-1;
        stk=new int[size];
    }

    void push(int data){
        if(this.isFull()){
            System.out.println("Stack Overflow!");
            return;
        }
        stk[++top]=data;
        System.out.println("Added element "+this.stk[top]);
    }

    int pop(){
        if(this.isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        
        return stk[top--];
    }

    int peek(){
        if(this.isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return stk[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==size-1;
    }

    public static void main(String[] args) {
        System.out.println("Stack Implementation");
        Stacks newStack=new Stacks(4);
        newStack.push(1);
        newStack.push(2);
        System.out.println("The top element is "+newStack.peek());
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        System.out.println("Popped element"+newStack.pop());
        System.out.println("The top element is "+newStack.peek());

    }
}