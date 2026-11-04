package br.com.soulpass.main;


import br.com.soulpass.conexao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection on = new Conexao().conexao();

        System.out.println("Conectado ao Banco de dados");

        on.close();
    }
}
