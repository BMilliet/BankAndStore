package banco.modelo;


import banco.excp.AcessoNegado;

import java.util.Map;
import java.util.TreeMap;

public class SistemaInterno {

    public static boolean autenticaSistema(Cliente cliente, String senha) throws AcessoNegado {
        if(cliente.getSenha() == senha){
            System.out.println("Acesso permitido");
            return true;
        } else {
            throw new AcessoNegado("Acesso negado");
        }
    }
}
