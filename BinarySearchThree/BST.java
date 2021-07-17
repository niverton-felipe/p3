package p3.BinarySearchThree;

public class BST <K extends  Comparable<K>, V>{

    private Node root;
    private int height;

    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private int size;
        private int height;
        public Node(K key, V value, int size, int height){
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size(root);
    }

    public int height(){
        return this.height;
    }

    private int size(Node node){
        if(node == null) return 0;
        return node.size;
    }

    public V get(K key){
        return get(root, key);
    }

    private V get(Node x, K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left,key);
        else if (cmp > 0) return get(x.right,key);
        else return x.value;
    }

    public void put(K key, V value){
        root = put(root, key, value,0);
    }

    private Node put(Node x, K key, V value, int h){
        if(h > this.height) height = h;
        if (x == null) return new Node(key, value, 1, h);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key, value, x.height + 1);
        else if(cmp > 0) x.right = put(x.right,key,value, x.height + 1);
        else  x.value = value;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

}
