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
        //verificar se está vazia (cabeça = elemento, rabo = elemento)
        //else (temp = cabeça, cabeça = elemento, cabeça.proximo = temp)
        if(isEmpty()){
            cabeca = elemento;
            rabo = elemento;
        }else {
            Conta temp = cabeca;
            cabeca = elemento;
            cabeca.proximo = temp;
        }
        inseridos++;
    }

    public void insertLast(Conta elemento) {
        //verificar se está vazia (cabeça = elemento, rabo = elemento)
        //else (temp = cabeça, cabeça = elemento, cabeça.proximo = temp)
        if(isEmpty()){
            cabeca = elemento;
            rabo = elemento;
        }else {
            rabo.proximo = elemento;
            rabo = elemento;
        }
        inseridos++;
    }

    public Conta removeFirst() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = cabeca;
            cabeca = cabeca.proximo;
            inseridos--;
        }
        return elementRemoved;
    }

    public Conta removeLast() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = rabo;
            //anterior a rabo tem que retornar null e virar rabo
            inseridos--;
        }
        return elementRemoved;
    }

    public int tamanho() {
        return this.inseridos;
    }

    public boolean isEmpty() {
        return this.inseridos == 0;
    }
}