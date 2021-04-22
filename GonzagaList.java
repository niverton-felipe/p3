package p3;

public class GonzagaList {
    private static final int TAM_INICIAL = 10;
    private static final int TAM_FINAL = 100;
    private Object[] listaInterna = new Object[TAM_INICIAL];
    private int indiceImpar = 1;
    private int indicePar = 2;
    private int inseridos;
    private int maiorIndice;

    public void add(Object element) throws ListaLotadaException{
        verificarTamanho();
        if(indiceImpar <= 9){
            listaInterna[indiceImpar] = element;
            maiorIndice = indiceImpar;
            indiceImpar += 2;
        } else if(indicePar <= 10){
            listaInterna[indicePar] = element;
            if(indicePar > maiorIndice){
                maiorIndice = indicePar;
            }
            indicePar += 2;
        }
        else{
            throw new ListaLotadaException("A lista já atingiu sua capacidade limite");
        }
        inseridos++;
        /* case when indiceImpar <= 9 then insert element
        listaInterna[indiceImpar] = element
        maiorIndice = indiceImpar
        indiceImpar += 2
        inseridos++
            else
            case when indiceImpar <= 10 then
            insert element listaInterna[indiceImpar] = element
            se(indicePar > maiorIndice) then maiorIndice = indicePar
            indicePar += 2
            inseridos++;
            case when indicepar > 10 throw new ListaLostadaException
        * */
        /*
        * */
    }

    public void remove(Object element) throws PosicaoInvalidaException{
        int position = get(element);
        verificarPosicao(position);
        for(int i = 1; i <= maiorIndice; i++){
            listaInterna[i] = listaInterna[i + 1];
        }
    }

    public int tamanho(){
        return inseridos;
    }

    private int get(Object element){
        for(int i = 1; i <= maiorIndice; i++){
            if(listaInterna[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    private void verificarPosicao(int position) throws  PosicaoInvalidaException{
        if (position <= 0 || position > maiorIndice) {
            throw new PosicaoInvalidaException("Posição inválida ou elemento inexistente na lista");
        }
    }

    private void verificarTamanho(){
        int controleLista = inseridos + 1;
        if(controleLista == listaInterna.length){
            Object[] auxiliar = new Object[controleLista * 2];
            for(int i = 0; i < controleLista; i++){
                auxiliar[i] = listaInterna[i];
            }
            listaInterna = auxiliar;
        }
    }
}
