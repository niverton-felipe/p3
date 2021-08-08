package p3.RedBlackBST;

public class RedBlackBST <K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        K key;
        V value;
        Node left, right;
        int N;
        boolean color;

        public Node(K key, V value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    public V get(K key){
        return get(root, key);
    }

    private V get(Node x, K key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left,key);
        else if(cmp > 0) return get(x.right,key);
        else return x.value;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node == null) return 0;
        return node.N;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(K key, V value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, K key, V value){
        if (h == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public K min(){
        if(root == null) return null;
        return min(root);
    }

    private K min(Node x){
        if(x.left == null) return x.key;
        return min(x.left);
    }

    public K max(){
        if(root == null) return null;
        return max(root);
    }

    private K max(Node x){
        if(x.right == null) return x.key;
        return max(x.right);
    }

    public K floor(K key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null) return t;
        else return x;
    }

    public K ceiling(K key){
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if(cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if( t != null) return t;
        else return x;
    }

    public float searchHint(){
        return (float) (1.0 * Math.log(size()));
    }

    public float searchMiss(){
        return (float) (2 * Math.log(size()));
    }
}