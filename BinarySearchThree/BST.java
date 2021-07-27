package p3.BinarySearchThree;

public class BST <K extends  Comparable<K>, V>{

    private Node root;
    private int height;
    private int ipl;
    private Node lastNode;

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

    public int internalPathLenght(){
        return ipl;
    }

    public float searchHint(){
        return (float) (1.4 * Math.log(size()));
    }

    public float searchMiss(){
        return (float) (3 * Math.log(size()));
    }

    public V get(K key){
        if(lastNode != null && lastNode.key.compareTo(key) == 0) return lastNode.value;
        return get(root, key);
    }

    private V get(Node x, K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left,key);
        else if (cmp > 0) return get(x.right,key);
        else{
            lastNode = x;
            return x.value;
        }
    }

    public void put(K key, V value){
        if(lastNode != null && lastNode.key.compareTo(key) == 0) {
            lastNode.value = value;
            return;
        }
        root = put(root, key, value,0);
    }

    private Node put(Node x, K key, V value, int h){
        if(h > this.height) height = h;
        if (x == null){
            ipl += h;
            lastNode = new Node(key, value, 1, h);
            return lastNode ;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left,key, value, x.height + 1);
        else if(cmp > 0) x.right = put(x.right,key,value, x.height + 1);
        else  x.value = value;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public K min(){
        if(root == null) return null;
        return min(root);
    }

    private K min(Node x){
        if(x.left == null) return x.key;
        return min(x.left);
    }

    private Node minNode(Node x){
        if(x.left == null) return x;
        return minNode(x.left);
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

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if(x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }

    public void delete(K key){
        root = delete(root,key);
    }

    private Node delete(Node x, K key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left,key);
        else if (cmp > 0) x.right = delete(x.right,key);
        else {
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = minNode(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

}
