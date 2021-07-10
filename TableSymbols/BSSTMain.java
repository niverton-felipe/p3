package p3.TableSymbols;

public class BSSTMain {
    public static void main(String[] args) {
        BinarySearchST bn = new BinarySearchST(10);
        bn.put("S",0);
        bn.put("A",1);
        bn.put("A",2);
        bn.put("U",2);
        System.out.println(bn.containsKey("D"));
        for(Object key : bn.keys()){
            System.out.println(key);
        }
        System.out.println(bn.costSearchHint());
        System.out.println(bn.costSearchMiss());
    }
}
