package QUEUE;

import DynamicArr.Array;

public class QueueArray<E> implements Queue<E>{

    Array<E> array;

    public QueueArray(int capacity){
        array = new Array<E>(capacity);
    }

    public QueueArray(){
        array = new Array<E>(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);

    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public String toString() {
        return "QueueArray{" +
                "array=" + array +
                '}';
    }

    public static void main(String[] args) {
        QueueArray queueArray1 = new QueueArray(5);
        for(int i = 0 ; i < 5; i++){
            queueArray1.enqueue(i);
        }
        System.out.println(queueArray1);

        queueArray1.dequeue();


        System.out.println(queueArray1);

        QueueArray queueArray = new QueueArray();
        for(int i = 0 ; i < 10 ; i++){
            queueArray.enqueue(i);
            System.out.println(i);
            System.out.println(queueArray);

            if(i % 3 == 2){
                queueArray.dequeue();
                System.out.println(queueArray);
            }
        }
    }
}
