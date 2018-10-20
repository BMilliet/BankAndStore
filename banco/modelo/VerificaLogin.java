package banco.modelo;

import banco.excp.SenhaInvalida;

public interface VerificaLogin {

    public abstract void setSenha(String senha) throws SenhaInvalida;
    public abstract String getSenha();
    public abstract boolean atentica(String senha);
}
