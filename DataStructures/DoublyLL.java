package dataStructures;

public class DoublyLL {
    Node head=null;
    Node tail=null;
    public class Node{
        Node next;
        Node prev;
        int data;

        public Node(int data) {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
        public void addNode(int data){
            Node newNode=new Node(data);
            if (head==null){
                head=tail=newNode;
            }
            else{
                newNode.prev=tail;
                tail.next=newNode;
                tail=newNode;
            }
        }
        public void displayNode(){
            Node curr=head;
            while(curr!=null){
                System.out.println(curr.data);
                curr=curr.next;
            }
        }
        public void displayNodeReverse(){
            Node curr=tail;
            while(curr!=null){
                System.out.println(curr.data);
                curr=curr.prev;
            }
        }

        public void insertBefore(int data,Node node){
            Node newNode=new Node(data);
            node.prev.next=newNode;
            
            

        }
        
        public static void main(String[] args) {
            DoublyLL ll=new DoublyLL();
            ll.addNode(1);
            ll.addNode(2);
            ll.addNode(3);
            ll.displayNode();
        }
        
    }

