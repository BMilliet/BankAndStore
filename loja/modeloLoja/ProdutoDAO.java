package loja.modeloLoja;

import loja.modeloLoja.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoDAO {

    private final Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public void addProdutoPrateleira(Produto produto) throws SQLException {
        String sql = "insert into Produto (nome, preco) values (?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
          //  statement.setString(3,produto.getCategoria());
            statement.execute();

            try(ResultSet rs = statement.getGeneratedKeys()){
                if(rs.next()){

                    int id = rs.getInt("id");
                    produto.setId(id);
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from Produto";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();

            TransformaResultadoEmProduto(statement, produtos);
        }
        return produtos;
    }

    private void TransformaResultadoEmProduto(PreparedStatement statement, List<Produto> produtos) throws SQLException {

        try(ResultSet rs = statement.getResultSet()) {
            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String categoria = rs.getString("categoria");


                Produto produto = new Produto(nome,preco,categoria);
                produto.setId(id);
                produtos.add(produto);

            }
        }
    }

    public List<Produto> busca(Produto produto) throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from Produto where categoria = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, produto.getCategoria());
            statement.execute();

            TransformaResultadoEmProduto(statement, produtos);
        }
        return produtos;
    }

    public void removeProdutoPrateleira(int idDelete) throws SQLException {
        String sql = "delete from Produto where id="+idDelete;
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.execute();
            int count = statement.getUpdateCount();
            System.out.println(count + " linhas atualizadas");
        }
    }
}
