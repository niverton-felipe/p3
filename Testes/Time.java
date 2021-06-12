package p3.Testes;

import java.util.ArrayList;
import java.util.Collections;

public class Time {
    private ArrayList<Jogador> plantel;
    private String nome;
    private ArrayList<Jogador> relacionados;


    public Time(String nome) {
        this.plantel = new ArrayList<>();
        this.nome = nome;
        this.relacionados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Jogador> getPlantel() {
        return plantel;
    }

    public ArrayList<Jogador> getRelacionados() {
        return relacionados;
    }

    public ArrayList<Jogador> relacionarJogadores(){
        Collections.sort(getRelacionados());
        Collections.reverse(getRelacionados());
        for(int i = 0; i < 11; i++){
            Jogador jogador = getRelacionados().get(i);
            getPlantel().add(jogador);
        }
        return getPlantel();
    }
}
