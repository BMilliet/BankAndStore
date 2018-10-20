package banco.modelo;


import banco.excp.AcessoNegado;

import java.util.Map;
import java.util.TreeMap;

public class AcessoConta {

    private Map<ContaCorrente, String> senhas = new TreeMap<>();

    public void autentica(VerificaLogin funcionario) throws AcessoNegado {
        if (senhas.containsKey(ContaCorrente.getSenha())){
            for (String senha:senhas) {
                if(this.senha == funcionario.getSenha()){
                    System.out.println("Acesso confirmado");
                }
            }
        }
        else {
            throw new AcessoNegado("Senha invalida");
        }
    }
}
