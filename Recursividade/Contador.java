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
        /*countDigits(240) count = 1   count + 2 => 3
        * countDigits(24) count = 1    count + 1 => 2
        * countDigits(2,4) count = 1
        * */
    }
}
