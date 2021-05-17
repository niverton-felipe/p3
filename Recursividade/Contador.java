package p3.Recursividade;

public class Contador {
    public static void main(String[] args) {
        System.out.println(countDigits(500));
    }

    public static int countDigits(double num){
        int count = 1;
        if(num < 0){
            num *= -1;
        }
        if(num >= 10){
            num /= 10;
            count += countDigits(num);
        }
        return count;
    }
}
