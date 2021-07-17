package p3.TableSymbols;

public class BSSTMain {
    public static void main(String[] args) {
        BinarySearchST bn = new BinarySearchST(10);
        bn.put("S",0);
        bn.put("B",1);
        bn.put("U",2);
        bn.put("U",2);
        bn.put("S",0);
        bn.put("S",0);
        bn.put("A",0);
        bn.put("C",0);
        bn.put("C",0);
        bn.put("C",0);
        bn.put("C",0);
        System.out.println(bn.containsKey("D"));
        for(Object key : bn.keys()){
            System.out.println(key);
        }
        System.out.println(bn.costSearchHint());
        System.out.println(bn.costSearchMiss());
        System.out.println(bn.min());
        System.out.println(bn.max());
        System.out.println(bn.select(10));
        System.out.println(bn.floor("B"));
        bn.removeMax();
        System.out.println(bn.max());
        bn.removeMin();
        System.out.println(bn.min());
    }
}
