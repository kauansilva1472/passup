package br.com.soulpass.dao;

import br.com.soulpass.conexao.Conexao;
import br.com.soulpass.entities.Acao;
import br.com.soulpass.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcaoDao {


    Connection MinhaConexao;

    public AcaoDao() throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();
    }


    public String inserir(Acao acao) throws SQLException {
        PreparedStatement stmt =
                MinhaConexao.prepareStatement("insert into TB_ACAO values (?,?,?,?)");
        stmt.setInt(1,acao.getIdAcao());
        stmt.setString(2,acao.getNomeAcao());
        stmt.setString(3, acao.getDescricao());
        stmt.setInt(4, acao.getPontosGerados());

        stmt.execute();
        stmt.close();

        return ("Acao Concluidar com sucesso");
    }

    public String atualizar(Acao acao) throws SQLException {

        PreparedStatement stmt =
                MinhaConexao.prepareStatement(
                        "UPDATE TB_ACAO SET PONTOS_GERADOS = ?, NOME_ACAO = ?, DESCRICAO = ? WHERE ID_ACAO = ?,"
                );
        stmt.setInt(1,acao.getPontosGerados());
        stmt.setString(2,acao.getNomeAcao());
        stmt.setString(3, acao.getDescricao());
        stmt.setInt(4, acao.getIdAcao ());

        stmt.execute();
        stmt.close();

        return "Acao atualizado com sucesso!";
    }

    public String selecionar(Usuario usuario) throws SQLException {

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("");

        stmt.execute();
        stmt.close();

        return "";
    }

    public ArrayList<Acao> selecionar() throws SQLException {
        ArrayList<Acao> listaAcao = new ArrayList<>();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("SELECT * FROM TB_ACAO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Acao acao  = new Acao();

            acao.setIdAcao(rs.getInt("ID_ACAO"));
            acao.setNomeAcao(rs.getString("NOME_ACAO"));
            acao.setDescricao(rs.getString("DESCRICAO"));
            acao.setPontosGerados(rs.getInt("PONTOS_GERADOS"));

            listaAcao.add(acao);
        }

        rs.close();
        stmt.close();

        return listaAcao;
    }


}
