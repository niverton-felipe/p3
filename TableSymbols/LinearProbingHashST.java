package p3.TableSymbols;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinearProbingHashST<K,V> {
    private int N;
    private int M = 16;
    private K[] keys;
    private V[] values;

    public LinearProbingHashST(){
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
    }

    public LinearProbingHashST(int cap){
        M = cap;
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public V get(K key){
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M){
            if(keys[i].equals(key)) return values[i];
        }
        return null;
    }

    public boolean contains(K key){
        return get(key) != null;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void delete(K key){
        if(!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        N--;
    }

    public Iterable<K> keys(){
        Queue<K> queue = new ArrayDeque<>();
        for(int i = 0; i < M; i++){
            if(keys[i] != null) queue.add(keys[i]);
        }
        return queue;
    }

    public float searchHint(){
        float loadFactor = N / M;
        float sondagens = 0;
        if (loadFactor <= 0.25) sondagens = (float) (N * 1.16);
        else sondagens = (float) (N * 1.5);
        return sondagens;
    }

    public float searchMiss(){
        float loadFactor = N / M;
        float sondagens = 0;
        if (loadFactor <= 0.25) sondagens = (float) (N * 1.39);
        else sondagens = (float) (N * 2.5);
        return sondagens;
    }

    private void resize(int capacity){
        LinearProbingHashST<K, V> tempLinearProbingHashST = new LinearProbingHashST<>(capacity);
        for(int i = 0; i < M;i++){
            if(keys[i] != null) tempLinearProbingHashST.put(keys[i],values[i]);
        }
        keys = tempLinearProbingHashST.keys;
        values = tempLinearProbingHashST.values;
        M = tempLinearProbingHashST.M;
    }
}