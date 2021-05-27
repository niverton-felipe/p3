package p3.ArvoreBinaria;

public class Departamento {
    private String nome;
    private int codigo;
    private Departamento direita;
    private Departamento esquerda;

    public Departamento(int codigo){
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setDireita(Departamento direita) {
        this.direita = direita;
    }

    public void setEsquerda(Departamento esquerda) {
        this.esquerda = esquerda;
    }

    public Departamento getDireita() {
        return direita;
    }

    public Departamento getEsquerda() {
        return esquerda;
    }
}
