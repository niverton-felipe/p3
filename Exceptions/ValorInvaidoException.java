package p3.Exceptions;

public class ValorInvaidoException extends Exception {
    public ValorInvaidoException(){
        super("Não é possível adicionar o valor null à lista");
    }
}
