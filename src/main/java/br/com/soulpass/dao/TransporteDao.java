
package br.com.soulpass.dao;

import br.com.soulpass.conexao.Conexao;
import br.com.soulpass.entities.Transporte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransporteDao {

    Connection MinhaConexao;

    // Inserir
    public String inserir(Transporte transporte)
            throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement(
                        "INSERT INTO TB_TRANSPORTE VALUES (?,?,?,?)"
                );

        stmt.setInt(1, transporte.getIdTransporte());
        stmt.setString(2, transporte.getTipoTransporte());
        stmt.setString(3, transporte.getNomeCartao());
        stmt.setString(4, transporte.getOperadora());

        stmt.execute();
        stmt.close();
        MinhaConexao.close();

        return "Transporte cadastrado com sucesso!";
    }

    // Atualizar
    public String atualizar(Transporte transporte)
            throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("UPDATE TB_TRANSPORTE SET OPERADORA = ?, " + "TIPO_TRANSPORTE = ?, NOME_CARTAO = ? " + "WHERE ID_TRANSPORTE = ?");

        stmt.setString(1, transporte.getOperadora());
        stmt.setString(2, transporte.getTipoTransporte());
        stmt.setString(3, transporte.getNomeCartao());
        stmt.setInt(4, transporte.getIdTransporte());

        stmt.execute();
        stmt.close();
        MinhaConexao.close();

        return "Transporte atualizado com sucesso!";
    }

    // Selecionar
    public ArrayList<Transporte> selecionar()
            throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();

        ArrayList<Transporte> listaTransporte = new ArrayList<>();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement(
                        "SELECT * FROM TB_TRANSPORTE"
                );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Transporte transporte = new Transporte();

            transporte.setIdTransporte(rs.getInt("ID_TRANSPORTE"));
            transporte.setTipoTransporte(rs.getString("TIPO_TRANSPORTE"));
            transporte.setNomeCartao(rs.getString("NOME_CARTAO"));
            transporte.setOperadora(rs.getString("OPERADORA"));

            listaTransporte.add(transporte);
        }

        rs.close();
        stmt.close();
        MinhaConexao.close();

        return listaTransporte;
    }


    // Deletar
    public String deletar(int id)
            throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement(
                        "DELETE FROM TB_TRANSPORTE WHERE ID_TRANSPORTE = ?"
                );

        stmt.setInt(1, id);
        int linhas = stmt.executeUpdate();

        stmt.close();
        MinhaConexao.close();

        return linhas > 0
                ? "Transporte excluido com sucesso!"
                : "Transporte nao encontrado!";
    }


    // Buscar por ID
    public Transporte buscarPorId(int id)
            throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement(
                        "SELECT * FROM TB_TRANSPORTE WHERE ID_TRANSPORTE = ?"
                );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Transporte transporte = null;

        if (rs.next()) {
            transporte = new Transporte();

            transporte.setIdTransporte(rs.getInt("ID_TRANSPORTE"));
            transporte.setTipoTransporte(rs.getString("TIPO_TRANSPORTE"));
            transporte.setNomeCartao(rs.getString("NOME_CARTAO"));
            transporte.setOperadora(rs.getString("OPERADORA"));
        }

        rs.close();
        stmt.close();
        MinhaConexao.close();

        return transporte;
    }

}

