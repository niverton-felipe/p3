package p3.ListasSequenciais;

public class MainMyArray {
    public static void main(String[] args) {
        MeuArray meuArray = new MeuArray();
        try{
            meuArray.add(1);
            meuArray.add(1);
            meuArray.add(2);
            meuArray.add(4);
            meuArray.add(4);
            meuArray.add(4);
            System.out.println(meuArray.size());
            meuArray.removeDuplicate();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(meuArray.size());
    }
}
