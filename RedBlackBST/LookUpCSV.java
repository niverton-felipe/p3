package p3.RedBlackBST;

import java.util.ArrayList;
import java.util.List;

public class LookUpCSV {
    public static void main(String[] args) {
        List<String> csv = new ArrayList<>();
        RedBlackBST<String,String> st = new RedBlackBST<>();
        int keyField = 0;
        int varField = 1;

        csv.add("www.ebay.com,66.135.192.87");
        csv.add("www.princeton.edu,128.112.128.15");
        csv.add("www.cs.princeton.edu,128.112.136.35");
        csv.add("www.harvard.edu,128.103.60.24");
        csv.add("www.yale.edu,130.132.51.8");
        csv.add("www.cnn.com,64.236.16.20");
        csv.add("www.google.com,216.239.41.99");
        csv.add("www.nytimes.com,199.239.136.200");
        csv.add("www.apple.com,17.112.152.32");
        csv.add("www.slashdot.org,66.35.250.151");
        csv.add("www.espn.com,199.181.135.201");
        csv.add("www.weather.com,63.111.66.11");
        csv.add("www.yahoo.com,216.109.118.65");

        for(String string : csv){
            String[] tokens = string.split(",");
            String key = tokens[keyField];
            String value = tokens[varField];
            st.put(key,value);
        }

        System.out.println(st.get("www.google.com"));
    }
}

/*
public class LookupCSV {

   public static void main(String[] args) {
      In in = new In(args[0]);
      int keyField = Integer.parseInt(args[1]);
      int valField = Integer.parseInt(args[2]);

      ST<String,String> st = new ST<String,String>();

      while (in.hasNextLine()) {
         String line = in.readLine();
         String[] tokens = line.split(",");
         String key = tokens[keyField];
         String val = tokens[valField];
         st.put(key, val);
      }
      while (!StdIn.isEmpty()) {
         String query = StdIn.readString();
         if (st.contains(query))
            StdOut.println(st.get(query));
      }
   }
}


* */