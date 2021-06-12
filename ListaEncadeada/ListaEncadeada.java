package p3.ListaEncadeada;

import p3.Exceptions.PosicaoInvalidaException;

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

    public Elemento removeByElement(Elemento element){
        Elemento elementRemoved = null;
        if(!isEmpty()){
            if(cabeca.equals(element)){
                elementRemoved = cabeca;
                cabeca = elementRemoved.proximo;
                inseridos--;
            } else {
                Elemento atual = cabeca;
                while (atual.proximo != null){
                    if(atual.proximo.equals(element)){
                        elementRemoved = atual.proximo;
                        atual.proximo = elementRemoved.proximo;
                        inseridos--;
                    } else {
                        atual = atual.proximo;
                    }
                }
            }
        }
        return elementRemoved;
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

    public boolean isEmpty(){
        return inseridos == 0;
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
