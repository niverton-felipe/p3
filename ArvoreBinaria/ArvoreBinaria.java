package p3.ArvoreBinaria;

public class ArvoreBinaria {
    private Departamento raiz;

    public Departamento getRaiz(){
        return raiz;
    }

    public void setRaiz(Departamento departamento){
        this.raiz = departamento;
    }

    public boolean isEmpty(){
        return raiz == null;
    }

    public void adicionarElemento(Departamento departamento){
        if(isEmpty()){
            setRaiz(departamento);
        }
    }

    public void preOrdem(Departamento no){
        if(no != null){
            System.out.println(no);
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }

    public void emOrdem(Departamento no){
        if(no != null){
            emOrdem(no.getEsquerda());
            System.out.println(no);
            emOrdem(no.getDireita());
        }
    }

    public void posOrdem(Departamento no){
        if(no != null){
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.println(no);
        }
    }

    public void inserir(int value){
        inserir(this.raiz,value);
    }

    private void inserir(Departamento node, int value){
        if(isEmpty()){
            setRaiz(new Departamento(value));
        }else{
            if(value <= node.getCodigo()){
                if(node.getEsquerda() != null){
                    inserir(node.getEsquerda(), value);
                }else{
                    node.setEsquerda(new Departamento(value));
                }
            }else {
                if(node.getDireita() != null){
                    inserir(node.getDireita(), value);
                }else {
                    node.setDireita(new Departamento(value));
                }
            }
        }
    }

    public int countFolhas(No raiz){
        int folhas = 0;
        if(raiz.getDireito() == null && raiz.getEsquerda() == null){
            folhas++;
        }
        if(raiz != null){
            folhas += countFolhas(raiz.getEsquerda());
            folhas += countFolhas(raiz.getDireito());
        }
        return folhas;
    }
}
