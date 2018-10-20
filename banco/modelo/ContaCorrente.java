package banco.modelo;

import banco.excp.*;
import loja.modeloLoja.Produto;

import java.io.*;
import java.util.*;

public class ContaCorrente extends Conta {

    private List<Produto> compras = new ArrayList<>();
    private double taxaSaque = 1;
    private double taxaTransfere = 0.5;
    public ContaPoupanca CP;
    private Map<String, Double> extrato = new TreeMap<String, Double>();
    private static int NumeOperacao = 0;
    Scanner scan = new Scanner(System.in);


    public ContaCorrente(int agencia, int numero) throws AgenciaInvalida, NumeroInvalido {
    }

    public void compraItem(List<Produto> produtos, String nome) throws Exception {
        for (Produto produto:produtos) {
            if(produtos.contains(produto)){
                if(produto.getNome().equals(nome)){
                    if(produto.getPreco() > getSaldo()){
                        throw new SaldoInsuficiente("Saldo Insuficiente para compra");
                    }
                    super.saca(produto.getPreco() - taxaSaque);

                    extrato.put(NumeOperacao+" "+produto.getNome(),produto.getPreco());
                    try{
                        this.compras.add(produto);
                        System.out.println("Compra: "+produto.getNome());
                    } catch (NullPointerException ex){
                        System.out.println("Produto inexistente");
                    }
                }
            } else {
                throw new ProdutoInexistente("Produto não encontrado");
            }
        }
    }

    public void extrato(){
         compras.forEach(System.out::println);
    }

    public void imprimeExtrato() throws IOException {
        PrintWriter extratoFile = new PrintWriter("extrato.txt");
        BufferedWriter bw = new BufferedWriter(extratoFile);

        for (Produto produto: compras) {
            bw.write(produto + System.getProperty("line.separator"));
        }
        bw.close();
    }

    @Override
    public void saca(double valor) throws SaldoInsuficiente {
        super.saca(valor + taxaSaque);
        NumeOperacao++;
        extrato.put(NumeOperacao+" Saque", valor);
    }

    @Override
    public void transfere(double valor, Conta outraConta) throws SaldoInsuficiente {
        super.saca(valor + taxaTransfere);
        outraConta.deposita(valor);
        extrato.put(NumeOperacao+" Transferencia", valor);
    }

    @Override
    public String toString() {
        return "Conta Corrente N: " + getNumero() + " Age: " + getAgencia() +
                "\nSaldo: " + getSaldo();
    }

    public List<Produto> getCompras() {
        return compras;
    }

    public void extratoConta(){
        for ( Map.Entry<String, Double> acao : extrato.entrySet() ) {
            System.out.println(acao.getKey() + " = "+ acao.getValue());
        }
    }

    @Override
    public void deposita(double valor) {
        super.deposita(valor);
        NumeOperacao++;
        extrato.put(NumeOperacao+" Deposito", valor);
    }
}
