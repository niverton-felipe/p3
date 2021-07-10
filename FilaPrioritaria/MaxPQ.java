package p3.FilaPrioritaria;

public class MaxPQ <T extends Comparable<T>>{
    private T[] pq;
    private int N;

    public MaxPQ(int maxSize){
        pq = (T[]) new Comparable[maxSize + 1];
    }

    public T get(int index){
        return pq[index];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return  N;
    }

    public void insert(T element){
        pq[++N] = element;
        swim(N);
    }

    public T delMax(){
        T max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j,j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        T element = pq[i];
        pq[i] = pq[j];
        pq[j] = element;
    }
}
