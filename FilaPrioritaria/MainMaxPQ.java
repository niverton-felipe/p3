package p3.FilaPrioritaria;

public class MainMaxPQ {
    public static void main(String[] args) {
        MaxPQ<Integer> inteiros = new MaxPQ<>(10);
        inteiros.insert(5);
        inteiros.insert(7);
        inteiros.insert(8);
        inteiros.insert(10);
        inteiros.insert(11);
        for(int i = 1; i <= inteiros.size(); i++){
            System.out.println(inteiros.get(i));
        }
        System.out.println("Testando função DelMax");
        inteiros.delMax();
        for(int i = 1; i <= inteiros.size(); i++){
            System.out.println(inteiros.get(i));
        }
    }
}
