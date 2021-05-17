package p3.Recursividade;

public class Somador {
    public static void main(String[] args) {
        System.out.println(soma(3));
    }

    private static int soma(int n){
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return n + soma(n+1);
        }
        return n + soma(n-1);
    }
}


