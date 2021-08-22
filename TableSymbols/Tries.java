package p3.TableSymbols;

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

        System.out.println(tries.limpa());
    }
}

