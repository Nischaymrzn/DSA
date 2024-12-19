package algorithms;

public class QueueUsingLinkedList {
    public class Node{
        Node next;
        int data;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }
    public class Queue{
        static Node head=null;
        static Node tail=null;
        
        public boolean isEmpty(){
            return head== null && tail==null;
        }
        public void add(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }   
        }
        public int remove(){
            if (isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            int front=head.data;
            if(head==tail){
                tail=null;
            }else{
                head=head.next;
            }
            return front;
        }
        public int peek(){
            if (isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            return head.data;
        }
        }
        public static void main(String[] args) {
            QueueUsingLinkedList q=new QueueUsingLinkedList();
            QueueUsingLinkedList.Queue q1=q.new Queue();
            
            q1.add(1);
            System.out.println(q1.peek());
            q1.add(2);
            System.out.println(q1.peek());
            q1.remove();
            System.out.println(q1.peek());
        }

    }  

   
