package p3.TableSymbols;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class SequentialSearchST<K, V> implements Iterable<K> {
    private Node first;
    private int inseridos;

    private class Node{
        private V value;
        private K key;
        private Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K k){
        if(!isEmpty()){
            for(Node current = first; current != null; current = current.next){
                if(current.key.equals(k)) return current.value;
            }
        }
        return null;
    }

    public void put(K k, V v){
        if (!isEmpty()){
            for(Node current = first; current != null; current = current.next){
                if(k.equals(current.key)){
                    current.value = v;
                    inseridos++;
                    return;
                }
            }
        }
        first = new Node(k, v,first);
        inseridos++;
    }

    public void delete(K key){
        if(!isEmpty()){
            if(key.equals(first.key)){
                if(inseridos == 1)first = null;
                else first = first.next;
                inseridos--;
            } else {
                Node current = first;
                while (current.next != null){
                    if(key.equals(current.next)){
                        current.next = current.next.next;
                        inseridos--;
                        return;
                    }
                    current = current.next;
                }
            }
        }
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public boolean containsValue(V value){
        if(!isEmpty()){
            for(Node current = first; current != null; current = current.next){
                if(current.value.equals(value)) return true;
            }
        }
        return false;
    }

    public void removeDuplicate(){
        if(!isEmpty()) removeDuplicate(first);
    }

    private void removeDuplicate(Node node){
        if(node.next != null){
            for(Node current = node; current.next!= null; current = current.next){
                while (current.next.value.equals(node.value) ) {
                    current.next = current.next.next;
                    inseridos--;
                }
            }
            removeDuplicate(node.next);
        }
    }

    public int searchMiss(K key){
        if(get(key) == (null)) return size();
        return -1;
    }

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }

    public Iterator<K> iterator() {return new ListIterator();}

    private class ListIterator implements Iterator<K>{
        private Node current = first;

        public boolean hasNext(){ return current != null; }

        public K next(){
            K item = (K) current.key;
            current = current.next;
            return item;
        }
    }

    public Iterable<K> keys(){
        Queue<K> queue = new ArrayDeque<>();
        if(!isEmpty()){
            Node current = first;
            while (current != null){
                queue.add(current.key);
                current = current.next;
            }
        }
        return queue;
    }

    /*
    *     public Iterable<K> keys() {
        Queue<K> queue = new ArrayDeque();
        for(int i = 0; i < N; i++) queue.add(keys[i]);
        return queue;
    }
     */

}
