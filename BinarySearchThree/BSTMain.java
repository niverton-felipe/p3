package p3.BinarySearchThree;

public class BSTMain {
    public static void main(String[] args) {
        BST<String,Integer> bst = new BST<>();
    bst.put("B",2);
    bst.put("C",3);
    bst.put("C",3);
    bst.put("A",1);
    //bst.put("D",1);
    bst.put("E",1);
    bst.put("B",1);
    bst.put("F",1);
        System.out.println(bst.searchHint());
        System.out.println(bst.searchMiss());
        System.out.println(bst.size());
        System.out.println(bst.isEmpty());
        System.out.println(bst.height());
        System.out.println(bst.internalPathLenght());
        System.out.println();
        System.out.println(bst.floor("H"));
        System.out.println(bst.min());
        System.out.println(bst.floor(bst.max()));
        System.out.println(bst.floor(bst.min()));
        System.out.println(bst.ceiling("D"));
    }
}
