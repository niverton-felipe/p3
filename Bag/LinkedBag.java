package p3.Bag;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedBag<T> implements Iterable<T> {
    private Node first;
    private int inseridos;

    private class Node{
        private T element;
        private Node next;
    }

    public void add(T element){
        Node oldFirst = first;
        first = new Node();
        first.element = element;
        first.next = oldFirst;
        inseridos++;
    }

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }

    public Iterator<T> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node current = first;

        public boolean hasNext(){
           return current != null;
        }

        public T next(){
            T item = (T) current.element;
            current = current.next;
            return item;
        }
    }
}
