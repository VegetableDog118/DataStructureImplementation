package Hashtable;

import java.util.TreeMap;

public class HashTable<K,V>{

    private TreeMap<K,V>[] hashtable;

    private int M;

    private int size;

    public HashTable(int M) {
       this.M =M;
       size = 0;
       hashtable = new TreeMap[M];
       for(int i = 0 ; i< M ; i++){
           hashtable[i] = new TreeMap<>();
       }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value){
        TreeMap map = hashtable[hash(key)];
        if(map.containsKey(key)){
            map.put(key, value);
        }else{
            map.put(key, value);
            size++;//数组长度还要增加
        }
    }

    public void remove(K key){
        TreeMap map = hashtable[hash(key)];
        if(map.containsKey(key)){
            map.remove(key);
            size--;
        }else{
            throw new IllegalArgumentException("do not have this key");
        }
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

}
