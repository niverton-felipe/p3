package p3.Testes;

public class Main {
    public static void main(String[] args) {

        Time corinthians = new Time("Corinthians");

        for(int i = 0; i < 23; i++){
            double qualidade = Math.random();
            qualidade *= 100;
            corinthians.getRelacionados().add(new Jogador(qualidade));
            System.out.println("Nome do time: " + corinthians.getNome() + "Jogador " + (i + 1) + " Qualidade: " + corinthians.getRelacionados().get(i).getQualidade());
        }

        System.out.println("\nSelecionando os 11 melhores jogadores");
        corinthians.relacionarJogadores();
        System.out.println("\nMostrando os 11 melhores jogadores");
        for(Jogador jogador : corinthians.getPlantel()){
            System.out.println(jogador.getQualidade());
        }










    }
}
