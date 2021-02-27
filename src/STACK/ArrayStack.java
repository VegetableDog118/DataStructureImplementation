package STACK;

import DynamicArr.Array;

public class ArrayStack<E> implements Stack<E>{

    Array<E> dynamicArray;

    public ArrayStack(int capacity){
        dynamicArray = new Array<E>(capacity);
    }

    public ArrayStack(){
        dynamicArray = new Array<E>();
    }

    @Override
    public int getSize() {
        return dynamicArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    public int getCapacity(){
        return dynamicArray.getCapacity();
    }

    @Override
    public void push(E e) {
        dynamicArray.addLast(e);

    }

    @Override
    public E pop() {
        return dynamicArray.removeLast();
    }

    @Override
    public E peek() {
        return dynamicArray.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "dynamicArray=" + dynamicArray +
                '}';
    }
}
