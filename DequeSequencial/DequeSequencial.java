package p3.DequeSequencial;

public class DequeSequencial {

    private static final int ALOCACAO_INICIAL = 3;
    private Conta[] arrayInterno = new Conta[ALOCACAO_INICIAL];
    private int inseridos;

    public void insertFirst(Conta elemento) {
        isFull();
        if(!isEmpty()){
            moveElementsRight();
        }
        arrayInterno[0] = elemento;
        inseridos++;
    }

    public void insertLast(Conta elemento) {
        isFull();
        arrayInterno[inseridos] = elemento;
        inseridos++;
    }

    public Conta removeFirst() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = arrayInterno[0];
            moveElementsLeft();
            inseridos--;
        }
        return elementRemoved;
    }

    public Conta removeLast() {
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = arrayInterno[inseridos - 1];
            arrayInterno[inseridos - 1] = null;
            inseridos--;
        }
        return elementRemoved;
    }

    public int size() {
        return inseridos;
    }

    public boolean isEmpty() {
        return inseridos == 0;
    }

    private void isFull(){
        if(inseridos == arrayInterno.length){
            Conta[] temp = new Conta[inseridos * 2];
            for(int i = 0; i < inseridos; i++){
                temp[i] = arrayInterno[i];
            }
            arrayInterno = temp;
        }
    }

    private void moveElementsRight(){
        for(int i = inseridos; i > 0; i--){
            arrayInterno[i] = arrayInterno[i - 1];
        }
    }

    private void moveElementsLeft(){
        for(int i = 0; i < inseridos; i++){
            arrayInterno[i] = arrayInterno[i + 1];
        }
    }
}
