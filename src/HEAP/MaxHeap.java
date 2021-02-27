package HEAP;

import DynamicArr.Array;

import java.util.ArrayList;
import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    public void shiftUp(int index){
        while(index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0){
            data.swap(index,parent(index));
            index = parent(index);
        }
    }

    public E findMax(){
        if(isEmpty()){
            throw new IllegalArgumentException("it is empty");
        }
        return data.get(0);
    }

    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    public void shiftDown(int index){
        while(leftChild(index) < data.getSize()){
            int i = leftChild(index);

            if(i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(index)) > 0){
                i++;
            }

            if(data.get(index).compareTo(data.get(i)) >= 0){
                break;
            }

            data.swap(index,i);
            index = i;
        }
    }

    public E replace(E e){
        E ret = findMax();

        data.set(0,e);
        shiftDown(0);

        return findMax();
    }

    public static void main(String[] args) {
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        Random random = new Random();
        for(int i = 0 ; i < 10 ; i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 10; i++){
            list.add(maxHeap.extractMax());
        }

        System.out.println(list);

    }
}
