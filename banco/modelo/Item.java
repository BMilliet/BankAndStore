package banco.modelo;

public class Item {

    private String coisa;
    private double preco;
    private int codigo;

    public Item(String coisa, double preco){
        this.coisa = coisa;
        this.preco = preco;
        this.codigo = (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Produto: " + this.coisa + " valor: " + this.preco + " codigo: " + this.codigo;
    }

    public String getCoisa() {
        return coisa;
    }

    public double getPreco() {
        return preco;
    }

    public int getId() {
        return codigo;
    }
}
