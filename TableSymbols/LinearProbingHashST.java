package p3.TableSymbols;

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
}