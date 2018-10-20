package loja.modeloLoja;

public class Produto {

    private Integer id;
    private String nome;
    private double preco;
    private String categoria;


    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "[Produto: "+getId()+ " " +getNome()+" "+getPreco()+" - "+getCategoria()+"]";
    }


}
