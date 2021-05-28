package p3.AlgoritmosOrdenacao;

public class OrdenacaoTeste {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] vector = {4,3,2,1};
        int[] vector2 = bubbleSort.ordenar(vector);
        for(int i = 0; i < vector2.length; i++){
            System.out.println(vector2[i]);
        }
    }
}
