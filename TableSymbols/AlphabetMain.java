package p3.TableSymbols;

import org.w3c.dom.ls.LSOutput;

public class AlphabetMain {
    public static void main(String[] args) {
        int[] encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        System.out.println(decoded1);
    }
}
/*
    public static void main(String[] args) {
        int[] encoded1  = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        StdOut.println(decoded1);

        int[] encoded2  = Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
        String decoded2 = Alphabet.DNA.toChars(encoded2);
        StdOut.println(decoded2);

        int[] encoded3 = Alphabet.DECIMAL.toIndices("01234567890123456789");
        String decoded3 = Alphabet.DECIMAL.toChars(encoded3);
        StdOut.println(decoded3);
*/