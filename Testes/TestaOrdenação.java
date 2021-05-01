package p3;

import java.util.*;

public class TestaOrdenação {
    public static void main(String[] args) {
        List<ContaPoupanca> contas = new LinkedList<>();
        contas.add(new ContaPoupanca(3, 2000, "Niverton", "09545687987"));
        contas.add(new ContaPoupanca(1, 4000, "Naldo", "09545687987"));
        contas.add(new ContaPoupanca(2, 3000, "Nadia", "09545687987"));
        for (Conta conta : contas){
            System.out.println(conta);
        }
        Collections.sort(contas);
        //Collections.sort(contas, Collections.reverseOrder());
        //Collections.rotate(contas,2);
        //Collections.shuffle(contas);

        for (Conta conta : contas){
            System.out.println(conta);
        }
    }
}
