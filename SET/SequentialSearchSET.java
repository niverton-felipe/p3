package p3.SET;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class SequentialSearchSET<K> implements Iterable<K> {
    private Node first;
    private int inseridos;

    private class Node{
        private K key;
        private Node next;
        public Node(K key, Node next){
            this.key = key;
            this.next = next;
        }
    }

    public boolean get(K key){
        if(!isEmpty()){
            for(Node current = first; current != null; current = current.next){
                if(current.key.equals(key)) return true;
            }
        }
        return false;
    }

    public void put(K k){
        if(!containsKey(k));
        first = new Node(k,first);
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
        return get(key);
    }

    public int searchMiss(K key){
        if(!get(key)) return size();
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
}
