package p3;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoa {
    List<Pessoa> pessoas;

    public ListaPessoa(){
        pessoas = new ArrayList<>();
    }

    public static void main(String[] args) {
        ListaPessoa pessoas = new ListaPessoa();
        Pessoa p = new Pessoa("Niverton");
    }
}
