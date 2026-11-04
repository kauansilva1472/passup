package br.com.soulpass.main.oracle;

import br.com.soulpass.dao.UsuarioDao;
import br.com.soulpass.entities.Usuario;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarEntidade {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double numero(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        int opcao = inteiro("\n\n Escolha o que deseja Deleta:" +
                "\n1 Usuario" +
                "\n2 Acao" +
                "\n3 Resgate" +
                "\n4 Transporte" );

        switch (opcao){
            case 1:
                UsuarioDao dao = new UsuarioDao();
                Usuario objUsuario = new Usuario();

                objUsuario.setIdUsuario(
                        inteiro("Informe o ID do Usuario para ser Deletado")
                );

                System.out.println(dao.deletar(objUsuario));
                break;
            case 2:

                break;
        }
    }
}
