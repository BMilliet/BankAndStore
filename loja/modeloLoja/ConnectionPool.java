package loja.modeloLoja;

import java.sql.Connection;
import java.sql.SQLException;
import org.hsqldb.jdbc.JDBCPool;

import javax.sql.DataSource;

public class ConnectionPool {

    private final DataSource dataSource;

    public ConnectionPool(){
        JDBCPool pool = new JDBCPool();
        pool.setURL("");
        pool.setUser("");
        pool.setPassword("");
        this.dataSource = pool;
    }

    public Connection getConnection() throws SQLException{
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
