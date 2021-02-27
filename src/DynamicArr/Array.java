package DynamicArr;

import java.util.Arrays;
import java.util.Objects;


public class Array<T> {
    private T[] data;

    private int size;//how many values in data

    //根据传入的数组容量来创建data数组


    public Array() {
        data = (T[]) new Object[10];
    }

    public Array(int size){
        data = (T[]) new Object[size];
    }

    public Array(T[] arr){
        data = (T[]) new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            data[i] = arr[i];
        }
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public void add(int index , T t){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("out of range");

        }

        if(size == data.length){
            resize(data.length*2);
        }

        for(int i = index ; i < size ; i++){
            data[i+1] = data[i];
        }

        data[index] = t;

        size++;

    }

    public void addFirst(T t){
        add(0,t);
    }

    public void addLast(T t){
        add(size , t);
    }

    public T get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("out of range");
        }
        return data[index];

    }

    public T getLast(){
        return data[size];
    }

    public void set(int index , T t){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("out of range");
        }
        data[index] = t;
    }

    public boolean contains(T t){
        for(int i = 0; i < size; i++){
            if(data[i] == t){
                return true;
            }
        }
        return false;
    }

    public int find(T t){
        for(int i = 0 ; i < size; i++){
            if(data[i] == t){
                return i;
            }
        }
        return -1;
    }

    public T remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("out of range");
        }

        T ret = data[index];
        for(int i = index + 1 ; i < size ; i++){
            data[i - 1] = data[i];
        }
        data [index] = null;
        size--;

        if(size == data.length/4){
            resize(data.length/4);
        }
        return ret;

    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size - 1);
    }

    public void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i , int j){
        if(i < 0 || i > size || j < 0 || j > size){
            throw new IllegalArgumentException("invalid index");
        }
        T mid = data[i];
        data[i] = data[j];
        data[j] = mid;
    }

    @Override
    public String toString() {
        return "Array{ " +
                "data=" + Arrays.toString(data) +
                ", size=" + size + ", capacity" + data.length +
                " }";
    }

}