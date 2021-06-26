package p3.Bag;

import java.util.ArrayList;

public class MainBag {
    public static void main(String[] args) {
        BagSequencial<Integer> bag = new BagSequencial<>();
        ArrayList<Integer> inteiros = new ArrayList();
        for(int i = 0; i < 20; i++){
            inteiros.add(i);
        }
        for(int i = 0; i < inteiros.size(); i++){
            bag.add(inteiros.get(i));
        }

        int N = bag.size();
        double soma = 0.0;
        for (int x : bag)
            soma += x;
        double media = soma/N;
        soma = 0.0;
        for (int x : bag)
            soma += (x - media)*(x - media);
        double desvpad = Math.sqrt(soma/(N-1));
        System.out.printf("Media: %.2f\n", media);;
        System.out.printf("Desv padrao: %.2f\n", desvpad);

        LinkedBag<String> linkedBag = new LinkedBag();
        linkedBag.add("Sousa");
        linkedBag.add("Pereira");
        linkedBag.add("Felipe");
        linkedBag.add("Níverton");
        System.out.println(linkedBag.size());
        System.out.println(linkedBag.isEmpty());
        for(String item : linkedBag){
            System.out.println(item);
        }
    }
}
