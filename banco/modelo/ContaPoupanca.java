package banco.modelo;

import banco.excp.AgenciaInvalida;
import banco.excp.NumeroInvalido;

public class ContaPoupanca extends Conta{

    private double investimento;

    public ContaPoupanca(int agencia, int numero) throws AgenciaInvalida, NumeroInvalido {
    }
}
