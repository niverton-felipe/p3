package p3.ListasSequenciais;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>  {

    public ContaPoupanca(int conta, double saldo, String titular, String cpf) {
        super(conta, saldo, titular, cpf);
    }

    @Override
    public int compareTo(ContaPoupanca o) {
//        if(this.getConta() > o.getConta()) return 1;
//        if(this.getConta() < o.getConta()) return -1;
          int resultado = this.getTitular().compareTo(o.getTitular());
          if (resultado > 1) return 1;
          if (resultado < 1) return -1;
        return 0;
    }
}
