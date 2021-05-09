package p3.DequeEncadeado;

public class DequeEncadeado {
    private Conta cabeca;
    private Conta rabo;
    private int inseridos;

    public DequeEncadeado() {
        this.cabeca = null;
        this.rabo = null;
        this.inseridos = 0;
    }

    public void insertFirst(Conta elemento) {
        if(isEmpty()){
            cabeca = elemento;
            rabo = elemento;
        }else {
            Conta temp = cabeca;
            cabeca.anterior = elemento;
            cabeca = elemento;
            cabeca.proximo = temp;
        }
        inseridos++;
    }

    public void insertLast(Conta elemento) {
        if(isEmpty()){
            cabeca = elemento;
            rabo = elemento;
        }else {
            Conta temp = rabo;
            rabo.proximo = elemento;
            rabo = elemento;
            rabo.anterior = temp;
        }
        inseridos++;
    }

    public Conta removeFirst() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = cabeca;
            if(inseridos == 1){
                clear();
            } else {
                cabeca = cabeca.proximo;
                cabeca.anterior = null;
            }
            inseridos--;
        }
        return elementRemoved;
    }

    public Conta removeLast() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = rabo;
            if(inseridos == 1){
                clear();
            }else {
                rabo = rabo.anterior;
                rabo.proximo = null;
            }
            inseridos--;
        }
        return elementRemoved;
    }

    public void clear(){
        this.cabeca = null;
        this.rabo = null;
    }

    public int size() {
        return this.inseridos;
    }
    public boolean isEmpty() {
        return this.inseridos == 0;
    }
}