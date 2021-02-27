package Map;

import LinkedList.LinkedList;
import Map.Map;

import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node {

        private K key;

        private V value;

        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


    private Node dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        if(contains(key)){
            getNode(key).value = value;
        }else{
            dummyHead.next = new Node(key,value,dummyHead.next);
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.key == key){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.value;
            }
            prev = prev.next;

        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("no this key");
        }
        node.value = value;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            stringBuilder.append(cur.key + "-" + cur.value + " -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");



        LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();

        map.add("a",1);
        map.add("b",2);

        System.out.println(map);
        map.set("a",3);
        System.out.println(map);


    }

}

