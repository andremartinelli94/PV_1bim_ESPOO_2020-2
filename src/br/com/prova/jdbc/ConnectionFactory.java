package br.com.prova.jdbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConnection() {
        
        try {
            return (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/BDPROVA1BI","userprova","123");
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
