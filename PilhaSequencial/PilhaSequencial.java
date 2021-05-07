package p3.PilhaSequencial;

public class PilhaSequencial {
    private  static final int ALOC_INICIAL = 10;
    private Object[] listaInterna = new Object[ALOC_INICIAL];
    private int inseridos;

    public void push(Object element){
        isFull();
        listaInterna[inseridos] = element;
        inseridos++;
    }

    public void clear(){
        listaInterna = new Object[ALOC_INICIAL];
        inseridos = 0;
    }

    public Object pop(){
        Object element = null;
        if(!isEmpty()){
            element = listaInterna[inseridos - 1];
            listaInterna[inseridos - 1] = null;
            inseridos--;
        }
        return element;
    }

    public Object peek(){
        Object element = null;
        if(!isEmpty()){
            element = listaInterna[inseridos - 1];
        }
        return element;
    }

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }

    private void isFull(){
        if(inseridos == listaInterna.length){
            Object[] aux = new Object[inseridos * 2];
            for(int i = 0; i < inseridos; i++){
                aux[i] = listaInterna[i];
            }
            listaInterna = aux;
        }
    }

}
