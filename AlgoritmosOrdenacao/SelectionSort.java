package p3.AlgoritmosOrdenacao;

public class SelectionSort {
    public static void main(String[] args) {
        int[] vector = {5,10,4,3,8,9,15,11};

        int ordenados = 0;

        for(int i = 0; i < vector.length; i++){
            int indexMaior = 0;
            for(int j = 1; j < vector.length - ordenados; j++){
                if(vector[j] > vector[indexMaior]){
                    indexMaior = j;
                }
            }
            int temp = vector[vector.length - 1 - ordenados];
            vector[vector.length - 1 - ordenados] = vector[indexMaior];
            vector[indexMaior] = temp;
            ordenados++;
        }

        for(int i = 0; i < vector.length; i++){
            System.out.print(vector[i] + " ");
        }

    }
}
