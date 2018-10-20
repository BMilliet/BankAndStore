package banco.excp;

public class SaldoInsuficiente extends Exception {
    public SaldoInsuficiente(String msg){
        super(msg);
    }
}
