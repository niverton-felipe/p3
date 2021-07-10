package p3.TableSymbols;

import java.util.Map;
import java.util.TreeMap;

public class STMain {
    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
        /*
        st.put(0, "A");
        st.put(1, "A");
        st.put(2, "A");
        st.put(3, "A");
        st.put(4, "A");
        st.put(5, "D");
        st.put(6, "D");
        st.put(7, "C");
        st.put(8, "A");
        */
        st.put(0, "C");
        st.put(1, "A");
        st.put(2, "A");
        st.put(3, "A");
        st.put(4, "A");
        st.put(5, "A");

        System.out.println(st.size());
        System.out.println(st.searchMiss(0));
        st.removeDuplicate();
        System.out.println(st.size());
       //System.out.println(st.searchHit());
       for(Integer key : st){
           System.out.println(key);
       }

    }
}
