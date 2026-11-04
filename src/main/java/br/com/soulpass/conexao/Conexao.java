package br.com.soulpass.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexao {

    private final static String URL = System.getenv("DB_URL");
    private final static String USUARIO = System.getenv("DB_USER");
    private final static String SENHA = System.getenv("DB_PASSWORD");

    public Connection conexao() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection(URL,USUARIO,SENHA);
    }

}
