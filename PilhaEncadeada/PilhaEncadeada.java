package p3.PilhaEncadeada;

public class PilhaEncadeada {
    private Elemento cabeca;
    private int inseridos;

    public void push(Elemento newElement){
        if(newElement == null) {
            throw new NullPointerException();
        }

        if (cabeca == null){
            cabeca = newElement;
        }
        else{
            Elemento temp = cabeca;
            cabeca = newElement;
            cabeca.proximo = temp;
        }
        inseridos++;
    }

    public Elemento pop(){
        Elemento elementoRemovido = null;
        if(!isEmpty()){
            elementoRemovido = cabeca;
            cabeca = cabeca.proximo;
        }
        return elementoRemovido;
    }

    public Elemento peek(){
        return cabeca;
    }

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }
}
