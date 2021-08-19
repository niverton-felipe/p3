package p3.TableSymbols;

public class Alphabet {
    public static final Alphabet BINARY = new Alphabet("01");
    public static final Alphabet OCTAL = new Alphabet("01234567");
    public static final Alphabet DECIMAL = new Alphabet("01234567");
    public static final Alphabet HEXADECIMAL = new Alphabet("0123456789ABCDEF");
    public static final Alphabet DNA = new Alphabet("ACTG");
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");
    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final Alphabet ASCII = new Alphabet(128);
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);
    public static final Alphabet UNICODE16 = new Alphabet(65536);

    private char[] alphabet;
    private int[] inverse;
    private int R;

    public Alphabet(String alpha){
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for(int i = 0; i < alpha.length(); i++){
            char c = alpha.charAt(i);
            if(unicode[c]) throw new IllegalArgumentException("Illegal alphabet: character = ' " + c + "'");
            else unicode[c] = true;
        }
        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for(int i = 0; i < inverse.length;i++){
            inverse[i] = -1;
        }

        for(int c = 0; c < R; c++){
            inverse[alphabet[c]] = c;
        }
    }

    private Alphabet (int R){
        alphabet = new char[R];
        inverse = new int[R];
        this.R = R;

        for(int i = 0; i < R; i++) alphabet[i] = (char) i;
        for(int i = 0; i < R; i++) inverse[i] = i;
    }

    public Alphabet() {
        this(256);
    }

    public boolean contains(char c){
        return inverse[c] != -1;
    }

    public int R(){
        return R;
    }

    public int lgR(){
        int lgR = 0;
        for (int t = R-1; t >= 1; t /= 2) lgR++;
        return lgR;
    }
}

/*


 */