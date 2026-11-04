package br.com.soulpass.dao;

import br.com.soulpass.conexao.Conexao;
import br.com.soulpass.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


public class UsuarioDao {

    Connection minhaConexao;

    public UsuarioDao() throws SQLException, ClassNotFoundException {

        this.minhaConexao = new Conexao().conexao();

    }

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt =
                minhaConexao.prepareStatement("insert into  TB_USUARIO values (?,?,?,?)");
                stmt.setInt(1, usuario.getIdUsuario());
                stmt.setString(2, usuario.getNome());
                stmt.setString(3, usuario.getEmail());
                stmt.setInt(4, usuario.getSaldoPontos());

                stmt.execute();
                stmt.close();

                return "Produto cadastro com sucesso!";
    }

    public String atualizar(Usuario usuario) throws SQLException {

        PreparedStatement stmt =
                minhaConexao.prepareStatement(
                        "UPDATE TB_USUARIO SET NOME = ?, EMAIL = ?, SALDO_PONTOS = ? WHERE ID_USUARIO = ?"
                );
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setInt(3, usuario.getSaldoPontos());
        stmt.setInt(4, usuario.getIdUsuario());

        stmt.execute();
        stmt.close();

        return "Usuario atualizado com sucesso!";
    }

    public String deletar(Usuario usuario) throws SQLException {

        PreparedStatement stmt =
                minhaConexao.prepareStatement("DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?");
        stmt.setInt(1,usuario.getIdUsuario());

        stmt.execute();
        stmt.close();

        return "Usuario Deletado com sucesso";
    }

    public ArrayList<Usuario> selecionar() throws SQLException {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();

        PreparedStatement stmt =
                minhaConexao.prepareStatement("SELECT * FROM TB_USUARIO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Usuario usuario = new Usuario();

            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NOME"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setSaldoPontos(rs.getInt("SALDO_PONTOS"));

            listaUsuario.add(usuario);
        }
        rs.close();
        stmt.close();

        return listaUsuario;
    }


    // Buscar por ID
    public Usuario buscarPorId(int id) throws SQLException {

        PreparedStatement stmt =
                minhaConexao.prepareStatement(
                        "SELECT * FROM TB_USUARIO WHERE ID_USUARIO = ?"
                );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Usuario usuario = null;

        if (rs.next()) {
            usuario = new Usuario();

            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setNome(rs.getString("NOME"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setSaldoPontos(rs.getInt("SALDO_PONTOS"));
        }

        rs.close();
        stmt.close();

        return usuario;
    }

}
