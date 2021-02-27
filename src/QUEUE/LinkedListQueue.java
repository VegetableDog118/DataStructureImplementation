package QUEUE;

import LinkedList.LinkedList;
import org.w3c.dom.Node;

public class LinkedListQueue<E> implements Queue {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object o) {
        if(tail == null){
            tail = new Node((E) o);
            head = tail;
        }else{
            tail.next = new Node((E)o);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("the queue is already empty...");
        }
        Node retNode = head;
        head = head.next;
        size--;
        return retNode.e ;
    }

    @Override
    public Object getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("the queue is already empty...");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("queue head: ");
        Node cur = head;
        while(cur != null){
            stringBuilder.append(cur.e + "  ");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        for(int i = 0 ; i < 10 ; i++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if(i % 3 == 2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
