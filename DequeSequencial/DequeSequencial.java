package p3.DequeSequencial;

public class DequeSequencial {

    private static final int ALOCACAO_INICIAL = 3;

    private Conta[] arrayInterno = new Conta[ALOCACAO_INICIAL];

    private int inseridos;

    public void insertFirst(Conta elemento) {
    //inseridos++
        //verificar se lista está chei
        //verificar se lista está vazia
        //mover elementos para direita
        isFull();
        if(!isEmpty()){
            for(int i = inseridos; i > 0; i--){
                arrayInterno[i] = arrayInterno[i - 1];
            }
        }
        arrayInterno[0] = elemento;
        inseridos++;
    }

    public void insertLast(Conta elemento) {
        isFull();
        arrayInterno[inseridos] = elemento;
        inseridos++;
        //inseridos++
        //verificar se lista esta cheia
        //adicionar na posicao[inseridos]
    }

    public Conta removeFirst() {
        //inseridos--
        //mover elementos para esquerda
        //verificar se lista está vazia
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = arrayInterno[0];
            for(int i = 0; i < inseridos; i++){
                arrayInterno[i] = arrayInterno[i + 1];
            }
            inseridos--;
        }
        return elementRemoved;
    }

    public Conta removeLast() {
        //verificar se lista está vazia
        //guardar elemento removido
        //inseridos--
        //retornar elemento removido
        Conta elementRemoved = null;
        if(!isEmpty()){
            elementRemoved = arrayInterno[inseridos - 1];
            arrayInterno[inseridos - 1] = null;
            inseridos--;
        }
        return elementRemoved;
    }

    public int tamanho() {
        return inseridos;
    }

    public boolean isEmpty() {
        return inseridos == 0;
    }

    public void isFull(){
        if(inseridos == arrayInterno.length){
            Conta[] temp = new Conta[inseridos * 2];
            for(int i = 0; i < inseridos; i++){
                temp[i] = arrayInterno[i];
            }
            arrayInterno = temp;
        }
    }
}
