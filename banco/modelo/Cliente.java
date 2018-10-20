package banco.modelo;

import banco.excp.AgenciaInvalida;
import banco.excp.NomeInvalido;
import banco.excp.NumeroInvalido;
import banco.excp.SenhaInvalida;

public class Cliente {

    private String nome;
    private String cpf;
    private String profissao;
    private double salario;
    private String senha;
    public ContaCorrente CC;
    public ContaPoupanca CP;

    public Cliente(String nome, String cpf) throws NomeInvalido {
        if(nome.length() < 2){
            throw new NomeInvalido("Nome deve ter mais de duas letras");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    public void CriaCC(String nomecc, int age, int numero) throws AgenciaInvalida, NumeroInvalido {
        if(age <= 0){
            throw new AgenciaInvalida("Numero de agencia Invalido");
        }
        if (numero <= 0){
            throw new NumeroInvalido("Numero da Conta Invalido");
        }
        nomecc = String.valueOf(CC);
        CC = new ContaCorrente(age,numero);
    }

    public void CriaCP(String nomecp, int age, int numero) throws AgenciaInvalida, NumeroInvalido {
        if(age <= 0){
            throw new AgenciaInvalida("Numero de agencia Invalido");
        }
        if (numero <= 0){
            throw new NumeroInvalido("Numero da Conta Invalido");
        }
        nomecp = String.valueOf(CP);
        CP = new ContaPoupanca(age,numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSenha(String senha) throws SenhaInvalida {
        if(senha.length() != 4){
            throw new SenhaInvalida("Senha deve ter 4 digitos");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
