package p3.SearchSubstring;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++){
            for(int c = 0; c < R; c++) dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt){
        int j, i;
        int M = pat.length();
        int N = txt.length();

        for(i = 0, j = 0; i < N && j < M; i++){
            j = dfa[txt.charAt(i)][j];
        }
        if(j == M) return i - M;
        else return N;
    }
}
