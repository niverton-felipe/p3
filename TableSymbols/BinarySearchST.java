package p3.TableSymbols;

import java.util.*;

public class BinarySearchST<K extends Comparable<K>, V> {
    private K[] keys;
    private V[] values;
    private K lastKey;
    private int lastIndex;
    private int N;

    public BinarySearchST(int capacity){
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public V get(K key){
        int i = cache(key);
        V value = null;
        if(i < N && keys[i].compareTo(key) == 0) value = values[i];
        return value;
    }

    public int size() {return N;}

    public boolean isEmpty(){return N == 0;}

    public void put(K key, V value){
        if(verifyMaxKey(key,value)) return;
        int i = cache(key);
        if(i < N && keys[i].compareTo(key) == 0){
            values[i] = value;
            return;
        }

        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public int costSearchHint(){
        return (int) Math.log(N);
    }

    public int costSearchMiss(){
        return costSearchHint();
    }

    private boolean verifyMaxKey(K key, V value){
        boolean result = false;
        if(!isEmpty()){
            if(keys[N-1].compareTo(key) == 0){
                values[N-1] = value;
                result = true;
            }else if(keys[N-1].compareTo(key) < 1){
                keys[N] = key;
                values[N++] = value;
                result = true;
            }
        }
        return result;
    }

    private int cache(K key){
        int i = 0;
        if (key.equals(lastKey)) i = lastIndex;
        else{
            lastKey = key;
            lastIndex = rank(key);
        }
        return i;
    }

    public boolean containsKey(K key){
        int i = cache(key);
        return keys[i].compareTo(key) == 0;
    }

    public int rank(K key){
        int lo = 0;
        int hi = N - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) lo = mid + 1;
            else if (cmp < 0)  hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    public Iterable<K> keys() {
        Queue<K> queue = new ArrayDeque();
        for(int i = 0; i < N; i++) queue.add(keys[i]);
        return queue;
    }
    /*
    @Override
    public Iterator<K> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<K>{
        private int indexCurrent = 0;
        public boolean hasNext() {return indexCurrent < N;}

        public K next(){
            K key = (K) keys[indexCurrent];
            indexCurrent += 1;
            return key;
        }
    }
    */

}
