package p3.TableSymbols;

import p3.RedBlackBST.RedBlackBST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class LookUpIndex {
    public static void main(String[] args) {
        String sp = "/";
        List<String> file = new ArrayList<>();
        /*
        file.add("Alanine,AAT,AAC,GCT,GCC,GCA,GCG");
        file.add("Arginine,CGT,CGC,CGA,CGG,AGA,AGG");
        file.add("Serine,TCT,TCA,TCG,AGT,AGC");
        file.add("Stop,TAA,TAG,TGA");
        file.add("Threonine,ACT,ACC,ACA,ACG");
        file.add("Tyrosine,TAT,TAC");
        file.add("Tryptophan,TGG");
        file.add("Valine,GTT,GTC,GTA,GTG");
        */
        file.add("Abducted (1986)/Borland, Skip/Brown, Jim/Camiro");
        file.add("Animal House (1978)/Allen, Karen/Bacon, Kevin/Baur, Lisa/Belushi");
        file.add("Apollo 13 (1995)/Allen, Ivan/Andrews, David/Bacon, Kevin/Barry");
        file.add("Apology (1986)/Allen, Seth/Andrei, Damir/Barber, Ellen/Bassett");

        RedBlackBST<String, ArrayDeque<String>> st = new RedBlackBST<>();
        RedBlackBST<String, ArrayDeque<String>> ts = new RedBlackBST<>();

        for(String line : file){
            String[] a = line.split(sp);
            String key = a[0];
            for(int i = 1; i < a.length; i++){
                String val = a[i];
                if(!st.contains(key)) st.put(key, new ArrayDeque<>());
                if(!ts.contains(val)) ts.put(val, new ArrayDeque<>());
                st.get(key).add(val);
                ts.get(val).add(key);
            }
        }

        for(String s : ts.get("Allen, Karen")) System.out.println(" " + s);
        for (String s : st.get("Animal House (1978)")) System.out.println(" " + s);
    }

    /*
    * public class LookupIndex {

      Serine
  TCT
  TCA
  TCG
  AGT
  AGC
TCG
  Serine
      while (!StdIn.isEmpty()) {
         String query = StdIn.readLine();
         if (st.contains(query))
            for (String s : st.get(query))  // foreach
               StdOut.println("  " + s);
         if (ts.contains(query))
            for (String s : ts.get(query))  // foreach
               StdOut.println("  " + s);
      }
   }
}
    * */
}
