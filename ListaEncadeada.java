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
            verificarElemento(novoElemento);
            if(index == 0) addCabeca(novoElemento);
            if(index == inseridos) addCalda(novoElemento);
            if (index < inseridos) {
                Elemento temp = cabeca;
                for(int i = 0; i < index - 1; i++){
                    temp = temp.proximo;
                }
                Elemento restante = temp.proximo;
                temp.proximo = novoElemento;
                novoElemento.proximo = restante;
                inseridos++;
            }
        } catch (PosicaoInvalidaException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    private void verificarPosicao(int index) throws PosicaoInvalidaException{
        if(index < 0 ) throw new PosicaoInvalidaException("Posição inválida");
    }

    private void verificarElemento(Elemento elemento){
        if(elemento == null) throw new IllegalArgumentException();
    }
    public int tamanho(){
        return inseridos;
    }
}
