package DoublyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class DLL<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    //Internal class of node<T>
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return data.toString();
        }
    }

    //empty DLL
    public void clear() {
        //指针一开始指向head
        Node<T> trav = head;
        while (trav != null) {
            //next 是trav的下一个 当前的trav是上一次循环的next
            Node<T> next = trav.next;
            //清空当前的node
            trav.prev = trav.next = null;
            trav.data = null;
            //指针指向next如果不是null则继续循环 这次循环的next 在下一个循环里变成了trav
            trav = next;
        }
        size = 0;
        head = tail = null;
    }

    //return the size of the DLL
    public int getSize() {
        return size;
    }

    // check the  DLL is empty or not
    public boolean isEmpty() {
        return getSize() == 0;
    }

    //add element to the end of the list
    public void add(T elem){
        addLast(elem);
    }

    //add node to the end of the list
    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem,null,null);
        }else{
            tail.next = new Node<T>(elem,tail,null);
            tail = tail.next;
        }
        size++;
    }

    //add node to the start of the list
    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem,null,null);
        }else{
            head.prev = new Node<T>(elem,null,head);
            head = head.prev;
        }
        size++;
    }

    //add an element at a specific index
    public void addAt(int index,T data) throws Exception{
        if(index < 0){
            throw new Exception("illegal index");
        }
        if(index == 0){
            addFirst(data);
        }
        if(index == size){
            addLast(data);
        }

        Node<T> temp = head;
        for(int i = 0; i < index;i++){
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data,temp,temp.next);
        (temp.next).prev = newNode;
        (temp).next = newNode;

        size++;
    }

    //check the value of the first element is exist
    public T peekFirst(){
        if(isEmpty()){
            throw new RuntimeException("EmptyList");
        }
        return head.data;
    }

    //check the value of the last element is exist
    public T peekLast(){
        if(isEmpty()){
            throw new RuntimeException("EmptyList");
        }
        return tail.data;
    }

    //remove the first value of the list
    public T removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("EmptyList");
        }

        T data = head.data;
        head = head.next; //the pointer forward one node
        size--;

        if(isEmpty()){
            tail = null;// if the list is empty we should set the tail to null
        }else{
            head.prev = null;//do a memory clean of node for the node we just removed
        }

        return data;//return the data we have just removed
    }

    //remove the last value of the list
    public T removeLast(){
        if(isEmpty()){
            throw new RuntimeException("EmptyList");
        }

        T data = tail.data;
        tail = tail.prev; //the pointer backward one node
        size--;

        if(isEmpty()){
            head = null;//if the list is empty we should set the head to null
        }else{
            tail.next = null;// do a memory clean of node for the node we just removed
        }

        return data;//return the data we have just removed
    }

    //remove the specific node from the list
    public T remove(Node<T> node){
        if(node.prev == null){
            removeFirst();
        }
        if(node.next == null){
            removeLast();
        }

        //make the pointers of adjacent node skip over the node to remove
        (node.next).prev = node.prev;
        (node.prev).next = node.next;

        T data = node.data;

        //clean memory
        node.data = null;
        node = node.prev = node.next = null;
        size--;
        return data;
    }

    //remove a node at a particular index
    public T removeAt(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("invalid index");
        }
        //search the index
        Node<T> trav = head;
        for(int i = 0; i != index;i++){
            trav = head.next;
        }
        return remove(trav);
    }

    //find an index of a particular object
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        //support searching for null
        if (obj.equals(null)) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.data.equals(null)) {
                    return index;
                }
            }
        } else{
            for (; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }
        }

        return -1;
    }

    //check is a value contained in the list
    public boolean contain(Object obj){
        return indexOf(obj) != -1 ;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while(trav != null){
            sb.append(trav.data);
            if(trav.next != null){
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
