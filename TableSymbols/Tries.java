package p3.TableSymbols;

import java.util.ArrayDeque;

public class Tries<V> {
    private static int R = 256;
    private Node root;

    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    public V get(String key){
        Node x = get(root, key,0);
        if( x == null) return null;
        return (V) x.val;
    }

    private Node get(Node x, String key, int d){
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void put(String key, V val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, V val, int d){
        if( x == null) x = new Node();
        if (d == key.length()){
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public void putNaoRecursivo(String key, V val){
        if (root == null) root = new Node();
        Node x = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(x.next[c] == null) x.next[c] = new Node();
            x = x.next[c];
        }
        x.val = val;
    }

    public V getNaoRecursivo(String key){
        Node x = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            x = x.next[c];
        }
        if (x == null) return null;
        return (V) x.val;
    }

    public boolean limpa(){
        if(root == null) return false;
        boolean result = limpa(root);
        return result;
    }

    private boolean limpa(Node x){
        boolean result = true;
        boolean folha = true;
        for(int i = 0; i < R; i++){
            if(x.next[i] != null){
                result &= limpa(x.next[i]);
                folha = false;
                if (!result) break;
            }
        }
        if(folha && x.val == null) return false;
        return result;
    }

    public void delete(String k){
        root = delete(root, k, 0);
    }

    private Node delete(Node x, String k, int d){
        if (x == null) return null;
        if(d == k.length()){
            x.val = null;
        }else{
            char c = k.charAt(d);
            x.next[c] = delete(x.next[c],k,d+1);
        }
        if (x.val != null) return x;
        for(char c = 0; c < R; c++){
            if (x.next[c] != null) return x;
        }
        return null;
    }

    public Iterable<String> keysWithPrefix(String pre){
        ArrayDeque<String> q = new ArrayDeque<>();
        collect(get(root, pre,0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, ArrayDeque<String> q){
        if (x == null) return;
        if(x.val != null) q.add(pre);
        for(char c = 0; c < R; c++){
            collect(x.next[c], pre + c, q );
        }
    }

    public Iterable<String> keysThatMatch(String s){
        ArrayDeque<String> q = new ArrayDeque<>();
        keysThatMatch(root, s, "", q, 0);
        return q;
    }

    private void keysThatMatch(Node x, String key, String pre, ArrayDeque<String> q, int d){
        if (x == null) return;
        if(d == key.length() && x.val != null){
            q.add(pre);
            return;
        }
        else if (d == key.length()) return;
        char c = key.charAt(d);
        if(c != 46) keysThatMatch(x.next[c], key, pre + c, q, d+1);
        else {
            for(int C = 0; C < R; C++) {
                char letter = Alphabet.EXTENDED_ASCII.toChar(C);
                keysThatMatch(x.next[C], key, pre+letter, q,d+1 );
            }
        }
    }

    public Iterable<String> keys(){
        return keysWithPrefix("");
    }

    public String longestPrefixOf(String s){
        int max = -1;
        Node x = root;
        for(int d = 0; x != null; d++){
            if (x.val != null) max = d;
            if (d == s.length()) break;
            x = x.next[s.charAt(d)];
        }
        if(max == -1) return null;
        else return s.substring(0, max);
    }



    public static void main(String[] args) {
        Tries<Integer> tries = new Tries<>();
        /*
        tries.putNaoRecursivo("bye",4);
        //tries.put("by",4);
       // System.out.println(tries.getNaoRecursivo("bye"));
        tries.put("",5);
        System.out.println(tries.get("by"));

        */
        //tries.put("a",null);
        tries.put("avai",2);
        tries.put("macapa",5);
        tries.put("zebra",10);
        tries.put("ola",5);
        tries.put("flamengo",1);
        tries.put("olaria", 6);
        tries.put("teste", 0);
        tries.put("she", 6);
        tries.put("the", 0);
        //tries.delete("olaria");

        System.out.println(tries.keysThatMatch(".he"));
    }
}

