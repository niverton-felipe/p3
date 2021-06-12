package p3.Testes;

public class Jogador implements Comparable<Jogador> {
    private Double qualidade;


    public Jogador(Double qualidade) {
        this.qualidade = qualidade;
    }



    public Double getQualidade() {
        return qualidade;
    }

    @Override
    public int compareTo(Jogador jogador) {
        return this.getQualidade().compareTo(jogador.getQualidade());
    }
}
