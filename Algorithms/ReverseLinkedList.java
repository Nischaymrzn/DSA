package algorithms;

public class ReverseLinkedList {
    Node head=null;
    Node tail=null;
    public class Node{
        Node next;
        int data;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }

        public void addNode(int data){
            Node newNode=new Node(data);
            if(head==null && tail==null){
                head=tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        public void printll(){
            Node curr=head;
            while(curr!=null){
                System.out.print(curr.data+"->");
                curr=curr.next;
            }
            System.out.println("null");
            
        }

        public void reverseList(){
            if (head==null || head.next==null){
                return;
            }
            Node curr=head.next;
            Node prev=head;
            
            while(curr!=null){
                Node next=curr.next;
                curr.next=prev;

                //update
                prev=curr;
                curr=next;

            }
            head.next=null;
            head=prev;
        }

        //recusive case
        public Node recursiveReverse(Node head){ //return Nodes
            if(head==null || head.next==null){
                return head;
            }
            Node newHead=recursiveReverse(head.next);  //performing recursion until last element and storing newhead in variable
            head.next.next=head;  //relationship between 2nd to 1st element
            head.next=null;      //removing relation from 1st to 2nd
            return newHead;
        }

        public static void main(String[] args) {
            ReverseLinkedList ll=new ReverseLinkedList();
            ll.addNode(1);
            ll.addNode(2);
            ll.addNode(3);
            ll.addNode(4);
            ll.addNode(5);
            ll.printll();
            ll.head=ll.recursiveReverse(ll.head);
            ll.printll();

            
            
        }
        


    
}
