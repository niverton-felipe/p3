package p3.DequeSequencial;

public class DequeSequencial {
    private static final int ALOCACAO_INICIAL = 3;
    private Conta[] arrayInterno = new Conta[3];
    private int inseridos;

    public DequeSequencial() {
    }

    public void insertFirst(Conta elemento) {
    }

    public void insertLast(Conta elemento) {
    }

    public Conta removeFirst() {
        return null;
    }

    public Conta removeLast() {
        return null;
    }

    public int tamanho() {
        return this.inseridos;
    }

    public boolean isEmpty() {
        return this.inseridos == 0;
    }
}
