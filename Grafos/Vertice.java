package p3.Grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int value;
    private List<Aresta> arestas;

    public Vertice(int value){
        this.value = value;
        this.arestas = new ArrayList<>();
    }

}
