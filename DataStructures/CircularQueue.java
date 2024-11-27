package DataStructures;

public class CircularQueue {

    int arr[];
    int size;
    int rear = -1;
    int front = -1;

    CircularQueue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int data) {  //enqueue
        if (isFull()) {
            System.out.println("Queue is full");
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int remove() { //dequeue
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int result = arr[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }

        return result;

    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[front];

    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(4); // Create instance of outer class

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        q.remove();
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
