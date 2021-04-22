package p3;

public class Conta {
    private int conta;
    private double saldo;
    private String titular;
    private String cpf;

    public Conta(int conta, double saldo, String titular, String cpf) {
        this.conta = conta;
        this.saldo = saldo;
        this.titular = titular;
        this.cpf = cpf;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
    saida.append("Conta: " + conta + "\n");
    saida.append("Saldo: " + saldo + "\n");
    saida.append("Titular: " + titular + "\n");
    saida.append("Cpf: " + cpf + "\n");
        return saida.toString();
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
