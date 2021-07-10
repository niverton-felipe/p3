package p3.ListasSequenciais;

import p3.Exceptions.PosicaoInvalidaException;
import p3.Exceptions.ValorInvaidoException;

public class MeuArray {
    private static final int TAM_INICIAL = 3;
    private Object[] listaInterna = new Object[TAM_INICIAL];
    private int inseridos;

    public boolean contains(Object element){
        for(Object object : listaInterna){
            if(object.equals(element)) return true;
        }
        return false;
    }

    public void add(Object element) throws ValorInvaidoException {
        if(element == null) throw new ValorInvaidoException();
        verificarTamanhoLimiteLista();
        listaInterna[inseridos] = element;
        inseridos++;
    }

    public void add(int position, Object element) throws PosicaoInvalidaException {
        /*
        * Verificar se posição é válida
        * Verificar se lista é preciso dobrar tamanho da lista
        * Lógica para empurrar valores para à esquerda
        * inseridos++;
        * */
        verificaPosicao(position);
        verificarTamanhoLimiteLista();
        for(int i = inseridos; i > position; i--){
            listaInterna[i] = listaInterna[i-1];
        }
        listaInterna[position] = element;
        inseridos++;
    }

    public Object get(int position) throws PosicaoInvalidaException{
        verificaPosicao(position);
        return listaInterna[position];
    }

    public int get(Object element){
        for (int i = 0; i < inseridos; i++){
            if(listaInterna[i].equals(element)) return i;
        }
        return  -1 ;
    }

    public void remove(Object element) throws PosicaoInvalidaException{
        int position = get(element);
        removeByIndex(position);
    }

    public void removeByIndex(int position) throws PosicaoInvalidaException{
        // verificar se índice está numa posição válida => se não retornar erro
        // verificar se o índice passado retornará o último índice válido, se sim, basta colocar o valor como null
        // se não, posicionar valores posteriores ao índice uma posição à esquerda
        verificaPosicao(position);
        if (position == inseridos - 1) {
            listaInterna[position] = null;
        }
        else{
            for(int i = position; i < inseridos - 1; i++){
                listaInterna[i] = listaInterna[i + 1];
            }
        }
        inseridos--;
    }

    public boolean isEmpty(){
        return inseridos == 0;
    }

    public int size(){
        return inseridos;
    }

    private void verificarTamanhoLimiteLista(){
        if (inseridos == listaInterna.length){
            Object[] listaDobrada = new Object[listaInterna.length * 2];
            for(int i = 0; i < listaInterna.length; i++){
                listaDobrada[i] = listaInterna[i];
            }
            listaInterna = listaDobrada;
        }
    }

    public void removeDuplicate(){
        try{
            if (inseridos > 1) removeDuplicate(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void removeDuplicate(int position) throws PosicaoInvalidaException{
        if (position < inseridos - 1){
            while(listaInterna[position].equals(listaInterna[position + 1])
                    && position < inseridos - 1){
                removeByIndex(position + 1);
            }
            removeDuplicate(position + 1);
        }
    }

    private void verificaPosicao(int position) throws PosicaoInvalidaException{
        if(position < 0 || position >= inseridos){
            throw new PosicaoInvalidaException("Índice inválido ou elemento não existente");
        }
    }
}
