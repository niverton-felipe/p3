package p3.AlgoritmosOrdenacao;

public class BubbleSort {

    public int[] ordenar(int[] vector){

        for(int i = 0; i < vector.length - 1; i++ )
            for (int j = 0; j < vector.length - 1 - i; j++){
                if(vector[j] > vector[j+1]){
                    int aux = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = aux;
                }
            }
        return vector;
    }
}
