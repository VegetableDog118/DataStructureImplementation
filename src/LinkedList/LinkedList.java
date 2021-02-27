package LinkedList;

public class LinkedList<E> {

    class Node{

        private E e;

        private Node next;

        public Node(E e , Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.next = null;
            this.e = e;
        }

        public Node(){
            this.next = null;
            this.e = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;

    private  int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 是在index的前面添加
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index is out of range");
        }

        Node cur = dummyHead;
        for(int i = 0 ; i < index; i++){
            cur = cur.next;
        }

        cur.next = new Node(e,cur.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index is out of range");
        }

        Node cur = dummyHead;
        for(int i = 0 ; i < size ; i++){
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size);
    }

    public void set(int index , E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index is out of range");
        }

        Node cur = dummyHead.next;
        for(int i = 0 ; i < size ; i++){
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e == e){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index is out of range");
        }

        Node cur = dummyHead;
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        Node delNode = cur.next;
        cur.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e == e){
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
            }
            prev = prev.next;

        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            stringBuilder.append(cur.e + " -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for(int i = 0 ; i < 5 ; i++){
            linkedList.add(i , i);
            System.out.println(linkedList);
        }
        linkedList.removeElement( 2);
        System.out.println();
        System.out.println(linkedList);
        System.out.println(linkedList.size);
        System.out.println();
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
