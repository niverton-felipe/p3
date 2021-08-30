package p3.SearchSubstring;

import java.util.ArrayDeque;
import java.util.Queue;

public class Brute {
    public static int search(String pat, String txt){
        int j, i;
        int M = pat.length();
        int N = txt.length();

        for(i = 0; i <= N - M; i++){
            for(j = 0; j < M; j++){
                if(txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if(j == M) return i;
        }
        return N;
    }

    public static int count(String pat, String txt){
            int j, i;
            int M = pat.length();
            int N = txt.length();
            int count = 0;
            for(i = 0; i <= N - M; i++){
                for(j = 0; j < M; j++){
                    if(txt.charAt(i+j) != pat.charAt(j)) break;
                }
                if(j == M) count += 1;
            }
            return count;
    }

    public static Queue<Integer> findAll(String pat, String txt){
        int j, i;
        int M = pat.length();
        int N = txt.length();
        Queue<Integer> q = new ArrayDeque<>();
        for(i = 0; i <= N - M; i++){
            for(j = 0; j < M; j++){
                if(txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if(j == M) q.add(i);
        }
        return q;
    }

    public static void searchAll(String pat, String txt){
        int j, i;
        int M = pat.length();
        int N = txt.length();
        Queue<Integer> q = new ArrayDeque<>();
        for(i = 0; i <= N - M; i++){
            for(j = 0; j < M; j++){
                if(txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if(j == M) q.add(i);
        }
        if(!q.isEmpty()){
            while (!q.isEmpty()) System.out.println("Padrão encontrado na posição: " + q.remove());
        }else{
            System.out.println("O padrão " + pat + " não foi encontrado no texto");
        }
    }

    public static int alternativeSearch(String pat, String txt){
        int j, i;
        int M = pat.length();
        int N = txt.length();

        for(i = 0, j = 0; i < N && j < M; i++){
            if(txt.charAt(i) == pat.charAt(j)) j++;
            else{
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        else return N;
    }

    public static void main(String[] args) {
        System.out.println(count("BY", "ABRADA"));
        searchAll("BY", "ABADA");
    }
}
