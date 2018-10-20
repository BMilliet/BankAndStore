package banco.modelo;

import banco.excp.AgenciaInvalida;
import banco.excp.NumeroInvalido;
import banco.excp.SaldoInsuficiente;


public abstract class Conta {

    private double saldo;
    private int agencia;
    private int numero;
    private static int total;


    public Conta() throws AgenciaInvalida, NumeroInvalido {
        total++;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public boolean naoTemSaldo(double saldo, double valor){
        if (this.saldo <= valor){
            return true;
        } else{
            return false;
        }
    }

    public void saca(double valor) throws SaldoInsuficiente {
        if(naoTemSaldo(this.saldo,valor)){
            throw new SaldoInsuficiente("Saldo Insuficiente");
        }
        this.saldo -= valor;
    }

    public void transfere(double valor, Conta outraConta) throws SaldoInsuficiente {
        saca(valor);
        outraConta.deposita(valor);
    }

    @Override
    public String toString() {
        return "Conta N: " + getNumero() + " Age: " + getAgencia() +
                "\nSaldo: " + getSaldo();
    }

    public static int getTotal(){
        return total;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }
}
