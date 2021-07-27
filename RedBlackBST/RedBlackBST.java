package p3.RedBlackBST;

public class RedBlackBST <K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left, right;
        int N;
        boolean color;
    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }
}

