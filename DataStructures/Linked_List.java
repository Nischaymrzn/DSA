
//This file contains the source code on how Linked_List from Scrap, how does it's inbuilt method works.
package DataStructures;
import java.util.LinkedList;

public class Linked_List {
    Node head;
    private int size;
 
    Linked_List () {
        size = 0;
    }
 
    public class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
 
    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }
 
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        } 
        System.out.println("null");
    }
 
    public void removeFirst() {
        if(head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        head = this.head.next;
        size--;
    }
 
 
    public void removeLast() {
        if(head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
 
        size--;
        if(head.next == null) {
            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;
    }
 
    public int getSize() {
        return size;
    }
    public static void main(String args[]) {
        Linked_List list = new Linked_List();
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.printList();
 
 
        list.addFirst("this");
        list.printList();
        System.out.println(list.getSize()); 
 
 
        list.removeFirst();
        list.printList();
 
 
        list.removeLast();
        list.printList();


        //actual inbuilt LinkedList
        LinkedList<String> linked_list=new LinkedList<>();
        linked_list.add("is");
        linked_list.add("always");
        linked_list.addFirst("John");
        linked_list.addLast("first");
        
        for(int i=0;i<linked_list.size();i++){
        
            System.out.print(linked_list.get(i)+"->");
        }
    }
 }
 

 
 
 
