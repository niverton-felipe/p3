package p3.PilhaEncadeada;

public class PilhaEncadeada {
    private Elemento cabeça;
    private int inseridos;

    public void push(Elemento newElement){
        if(newElement == null) {
            throw new NullPointerException();
        }

        if (cabeça == null){
            cabeça = newElement;
        }
        else{
            Elemento temp = cabeça;
            cabeça = newElement;
            cabeça.proximo = temp;
        }
        inseridos++;
    }

    public Elemento pop(){
        Elemento elementoRemovido = null;
        if(!isEmpty()){
            elementoRemovido = cabeça;
            cabeça = cabeça.proximo;
        }
        return elementoRemovido;
    }

    public Elemento peek(){
        Elemento elementoNoTopo = null;
        if(!isEmpty()){
            elementoNoTopo = cabeça;
        }
        return elementoNoTopo;
    }

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }
}
