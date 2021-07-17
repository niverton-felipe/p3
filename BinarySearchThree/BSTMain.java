package p3.BinarySearchThree;

public class BSTMain {
    public static void main(String[] args) {
        BST<String,Integer> bst = new BST<>();
    bst.put("B",2);
    bst.put("C",3);
    bst.put("A",1);
    bst.put("D",1);
        System.out.println(bst.size());
        System.out.println(bst.isEmpty());
        System.out.println(bst.height());
    }
}
