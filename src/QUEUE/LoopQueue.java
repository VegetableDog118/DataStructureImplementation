package QUEUE;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }


    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public void enqueue(E e) {
        if((tail + 1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("can not dequeue from an empty queue");
        }
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("it is empty");
        }
        return data[front];
    }


    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(10);
        for(int i = 0 ; i < 10 ; i++){
            loopQueue.enqueue(i);
            System.out.println(i);
            System.out.println(loopQueue);

            if(i % 3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }
}
