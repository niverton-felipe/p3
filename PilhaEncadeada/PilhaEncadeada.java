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

    public int size(){
        return inseridos;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }

    /*
    * size
    * isEmpty
    * peek
    * push
    * pop
    * */

}
