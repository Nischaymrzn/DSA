package DataStructures;

import java.util.HashMap;

public class LRUcache{
    public static class Node{
        int k;
        int v;
        Node next;
        Node prev;
        Node(int key,int value){
            this.k=key;
            this.v=value;
            this.next=this.prev=null;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache=new HashMap<>();
    public LRUcache(int capacity) {
        this.capacity=capacity;
    }

    
    void put(int key,int value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        if(cache.size()==capacity){
            remove(dummyTail.prev);
        }
        Node newNode=new Node(key,value);
        insert(newNode);
    }
    Node dummyHead=new Node(0,0);
    Node dummyTail=new Node(0, 0);

    void insert(Node newNode){
        if(dummyHead.next==null){
            newNode.prev=dummyHead;
            newNode.next=dummyTail;
            dummyHead.next=newNode;
            dummyTail.prev=newNode;
        }
        else{
            newNode.next=dummyHead.next;
            dummyHead.next.prev=newNode;
            newNode.prev=dummyHead;
            dummyHead.next=newNode;
        }
        cache.put(newNode.k, newNode);
    }

    int get(int key){
        Node node=cache.get(key);
        if(node != null){
            remove(node);
            return node.v;
        }
        System.out.println("No such data");
        return -1;
    }
    void remove(Node node){
        cache.remove(node.k);
        node.prev.next=node.next;
        node.next.prev=node.prev;

        node.next=dummyHead.next;
        dummyHead.next.prev=node;
        node.prev=dummyHead;
        dummyHead.next=node;
    }

    public static void main(String[] args) {
        LRUcache l=new LRUcache(3);
        l.get(1);
        l.put(1, 10);
        l.put(2, 20);
        l.put(3, 30);
        System.out.println(l.get(1));
        l.put(4, 40);
        System.out.println(l.get(4));
    }

}