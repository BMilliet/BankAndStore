package banco.excp;

public class ProdutoInexistente extends Exception {
    public ProdutoInexistente(String msg){
        super(msg);
    }
}
