package p3.TableSymbols;

import java.util.ArrayDeque;
import java.util.Queue;

public class SeparateChainingHashST<K, V> {
    private int N;
    private int M;

    private SequentialSearchST<K, V>[] st;

    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<K, V>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++){
            st[i] = new SequentialSearchST<>();
        }
    }

    public SeparateChainingHashST(){
        this(997);
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key){
        int h = hash(key);
        return st[h].get(key);
    }

    public boolean contains(K key){
        int h = hash(key);
        return st[h].containsKey(key);
    }

    public void delete(K key){
        if(contains(key)){
            int h = hash(key);
            st[h].delete(key);
        }
    }

    public void put(K key, V value){
        int h = hash(key);
        st[h].put(key,value);
        N++;
    }

    public Iterable<K> keys(){
        Queue<K> queue = new ArrayDeque<>();
        for(int i = 0; i < M; i++){
            for(K key : st[i].keys())queue.add(key);
        }
        return queue;
    }
}