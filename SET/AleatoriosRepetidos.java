package p3.SET;

public class AleatoriosRepetidos {
    /*
    * (SW 3.5.30) Filtro de repetidos. Escreva um programa Dedup que receba uma lista de números e elimine os
    * repetidos. Escreva um programa AleatoriosRepetidos que receba inteiros M, N e T na linha de comando e repita o
    * seguinte experimento T vezes: gere N inteiros aleatórios entre 0 e M−1 e veja quantos repetidos são gerados.
    * (A teoria da probabilidades diz que o número de repetidos deve ser aproximadamente 1 − e−N/M.)
    * Use o seu programa com T igual a 10 e N igual a 10^7, 10^8, e 10^9, e com M igual a N/2, N e 2N.
    * Cronometre seus experimentos com Stopwatch.
    */
    public static void main(String[] args) {
        int capacity = 80000;
        int numbers = 10000000;
        BinarySearchSET<Integer> conjunto = new BinarySearchSET<>(capacity);
        int repetidos = 0;
        int value = 0;
        for(int i = 0; i < capacity; i++){
            value = (int) (Math.random() * capacity);
            if(conjunto.contains(value)) repetidos++;
            else conjunto.put(value);
        }
        System.out.println(repetidos);
    }

}
