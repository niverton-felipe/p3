package p3.Bag;

import java.util.Iterator;
import java.util.ListIterator;

public class BagSequencial <T> implements Iterable<T>{
    private int inseridos;
    private static final int TAM_INICIAL = 10;
    private T[] listaInterna = (T[]) new Object[TAM_INICIAL];

    public int size() {return inseridos;}

    public boolean isEmpty(){return inseridos == 0;}

    public void add(T element) {
        try{
            verifyNull(element);
            verifySize();
            listaInterna[inseridos++] = element;
        }catch (NullElementException e){
            e.printStackTrace();
        }

    }

    private void verifySize(){
        if (inseridos == listaInterna.length){
            T[] temp = (T[]) new Object[inseridos * 2];
            for(int i = 0; i < listaInterna.length; i++){
                temp[i] = listaInterna[i];
            }
            listaInterna = temp;
        }
    }

    private void verifyNull(T element) throws NullElementException{
        if(element == null) {throw new NullElementException("Não é permitido a adição de elementos null");}
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private int posicao = 0;
        public boolean hasNext() {
            return posicao < inseridos;
        }

        public T next() {
            T element = (T) listaInterna[posicao++];;
            return element;
        }
    }
}
