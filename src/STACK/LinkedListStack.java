package STACK;

import LinkedList.LinkedList;

public class LinkedListStack<E> implements Stack {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(Object o) {
        linkedList.addFirst((E)o);
    }

    @Override
    public Object pop() {
        return linkedList.removeFirst();
    }

    @Override
    public Object peek() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "linkedList=" + linkedList +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for(int i = 0 ; i < 5 ; i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }


}
