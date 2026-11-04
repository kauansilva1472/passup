package br.com.soulpass.dao;

import br.com.soulpass.conexao.Conexao;
import br.com.soulpass.entities.Resgate;
import br.com.soulpass.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResgateDao {

    Connection MinhaConexao;

    public ResgateDao() throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();
    }

    public String inserir(Resgate resgate) throws SQLException, ClassNotFoundException {

        this.MinhaConexao = new Conexao().conexao();
        PreparedStatement stmt =
                MinhaConexao.prepareStatement("insert into TB_RESGATE values (?,?,?,?)");
        stmt.setInt(1, resgate.getIdResgate());
        stmt.setInt(2,resgate.getQuantidadePonto());
        stmt.setDouble(3,resgate.getValorCredito());
        stmt.setString(4,resgate.getStatus());

        stmt.execute();
        stmt.close();

        return ("Resgatado os pontos com sucesso");
    }

    public String atualizar(Resgate resgate) throws SQLException {

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("UPDATE TB_RESGATE SET STATUS = ?, QUANTIDADE_PONTO = ?, VALOR_CREDITO = ? WHERE ID_RESGATE = ?");
        stmt.setString(1, resgate.getStatus());
        stmt.setInt(2,resgate.getQuantidadePonto());
        stmt.setDouble(3,resgate.getValorCredito());
        stmt.setInt(4,resgate.getIdResgate());

        stmt.execute();
        stmt.close();

        return "Resgate atualizado com sucesso!";
    }

    public String selecionar(Usuario usuario) throws SQLException {

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("");

        stmt.execute();
        stmt.close();

        return "";
    }

    public ArrayList<Resgate> selecionar() throws SQLException {
        ArrayList<Resgate> listaResgate = new ArrayList<>();

        PreparedStatement stmt =
                MinhaConexao.prepareStatement("SELECT * FROM TB_RESGATE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Resgate resgate = new Resgate();

            resgate.setIdResgate(rs.getInt("ID_RESGATE"));
            resgate.setQuantidadePonto(rs.getInt("QUANTIDADE_PONTO"));
            resgate.setValorCredito(rs.getInt("VALOR_CREDITO"));
            resgate.setStatus(rs.getString("STATUS"));

            listaResgate.add(resgate);
        }
        rs.close();
        stmt.close();

        return listaResgate;
    }

}
