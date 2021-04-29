package p3;

public class ListaEncadeada {
    public Elemento cabeca;
    private int inseridos;

    public void addCabeca(Elemento novoElemento){
        if(cabeca == null){
            cabeca = novoElemento;
        } else {
            Elemento temp = cabeca;
            cabeca = novoElemento;
            cabeca.proximo = temp;
        }
        inseridos++;
    }

    public void addCalda(Elemento novoElemento){
        if(cabeca == null){
            cabeca = novoElemento;
        }else{
            Elemento temp = cabeca;
            while (temp.proximo != null){
                temp = temp.proximo;
            }
            temp.proximo = novoElemento;
        }
        inseridos++;
    }

    public void addIndex(int index, Elemento novoElemento){
        try {
            verificarPosicao(index);
            Elemento temp = cabeca;
            Elemento anterior = null;
            for(int i = 0; i < index; i++){
                if(anterior == null){
                    anterior = cabeca;
                } else{
                    anterior = anterior.proximo;
                }
                temp = temp.proximo;
            }
            anterior.proximo = novoElemento;
            novoElemento.proximo = temp;
            inseridos++;
        } catch (PosicaoInvalidaException e){
            e.printStackTrace();
        }

    }

    private void verificarPosicao(int index) throws PosicaoInvalidaException{
        if(index < 0 || index > inseridos) throw new PosicaoInvalidaException("Posição inválida");
    }
    public int tamanho(){
        return inseridos;
    }
}
