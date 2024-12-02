package DataStructures;

public class SinglyLL {
    Node head=null;
    Node tail=null;
    
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    public void addNode(int data){
        Node newNode=new Node(data);  //newNode has the address
        if(head==null && tail==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode; //creating link between current last element of node and newly made node
            tail=newNode;  //updating the tail beacause newNode is the last element now
        }
        //else{
        //     Node current=head;
        //     while(current.next!=null){
        //         current=current.next; //to travel through node
        //     }
        //     current.next=newNode;
        // }

    }

    public void addFirst(int data){
        Node newNode=new Node(data);  //newNode has the address
        if(head==null && tail==null){
            head=tail=newNode;
        }else{
            newNode.next=head;  //newNode getting reference to head
            head=newNode;  //updating new Head
        }
    }

    public int removeNode(){
        if(head==null && tail==null){
            return -1;
        }
        if(head==tail){
            int curr=head.data;
            head=tail=null;
            return curr;
        }
        Node curr=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            curr=curr.next;
            lastNode=lastNode.next;
        }
        curr.next=null;
        tail=curr;
        return 1;
    }

    public int removeFirst(){
        if(head==null || tail==null){
            System.out.println("Empty Linked List");
            return -1;
        }
        int curr=head.data;
        head=head.next;
        return curr;
    }

   
    void printList(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            
            curr=curr.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        SinglyLL s=new SinglyLL();
        s.addNode(1);
        s.addNode(2);
        s.addNode(3);
        s.addNode(4);
        s.printList();
        System.out.println(s.removeFirst());
        s.printList();
        System.out.println(s.removeNode());
        s.printList();
        s.addNode(7);
        s.printList();
    }
}
