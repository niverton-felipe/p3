package p3.ArvoreBinaria;

public class ArvoreBinaria {

    public No getRaiz(No qualquerNo){
         if(qualquerNo.getRaiz() == null){
             return qualquerNo;
         }
         return getRaiz(qualquerNo);
    }
}
