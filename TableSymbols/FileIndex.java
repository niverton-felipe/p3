package p3.TableSymbols;

import p3.RedBlackBST.RedBlackBST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FileIndex {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        RedBlackBST<String, ArrayDeque<String>> ST = new RedBlackBST<>();
        names.add("D:\\TESTES\\ex1.txt");
        names.add("D:\\TESTES\\ex2.txt");
        names.add("D:\\TESTES\\ex3.txt");
        names.add("D:\\TESTES\\ex4.txt");
        for(String name : names){
            try {
                BufferedReader br = new BufferedReader (new FileReader(name));
                while(br.ready()){
                    String[] words = br.readLine().split(" ");
                    for(String word : words){
                        if(!ST.contains(word)) ST.put(word, new ArrayDeque<>());
                        ST.get(word).add(name);
                    }
                }
                br.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(ST.contains("best")){
            for(String br : ST.get("best")) System.out.println(br);
        }
    }
}