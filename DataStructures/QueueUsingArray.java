package DataStructures;

import java.util.Arrays;

public class QueueUsingArray {
    int[] arr;
    int size;
    int rear=-1;
    public QueueUsingArray(int size) {
        arr=new int[size];
        this.size=size;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    public boolean isFull(){
        return rear==size-1;
    }

    public void add(int data){
        if (isFull()){
            System.out.println("Queue Full");
        }
        rear+=1;
        arr[rear]=data;
    }

    public int remove(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front=arr[0];
        for (int i=0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        arr[rear]=0;
        rear=rear-1;
        return front;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        }
        return arr[0];
    }


    public static void main(String[] args) {
        QueueUsingArray q=new QueueUsingArray(4);
        q.add(1);
        q.add(2);
        q.add(3);
        
        

        System.out.println(Arrays.toString(q.arr));
        q.remove();
        System.out.println(Arrays.toString(q.arr));

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();

        }
        
        

    }

    
}
