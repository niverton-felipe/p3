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

    public void clear(){
        cabeca = null;
        inseridos = 0;
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

    public int sizeRecursivo(Elemento cabeca){
        int count = 0;
        if(cabeca != null){
            Elemento next = cabeca.proximo;
            count += 1;
            count += sizeRecursivo(next);
        }
        return count;
    }

    public void clearRecursivo(){
        if(cabeca != null){
            pop();
            clearRecursivo();
        }
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }
}
