package br.com.soulpass.main.oracle;

import br.com.soulpass.dao.AcaoDao;
import br.com.soulpass.dao.ResgateDao;
import br.com.soulpass.dao.TransporteDao;
import br.com.soulpass.dao.UsuarioDao;
import br.com.soulpass.entities.Acao;
import br.com.soulpass.entities.Resgate;
import br.com.soulpass.entities.Transporte;
import br.com.soulpass.entities.Usuario;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirEntidade {

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

        //USUARIO
        UsuarioDao dao = new UsuarioDao();
        Usuario objUsuario = new Usuario();

        objUsuario.setIdUsuario(inteiro("Informe o id "));
        objUsuario.setNome(texto("Nome"));
        objUsuario.setEmail(texto("Email"));
        objUsuario.setSaldoPontos(inteiro("Saldo Pontos"));

        System.out.println(dao.inserir(objUsuario));

        //ACAO
        AcaoDao Acaodao = new AcaoDao();
        Acao objAcao = new Acao();

        objAcao.setIdAcao(inteiro("Informe ID da acao"));
        objAcao.setNomeAcao(texto("Nome ação"));
        objAcao.setDescricao(texto("Descrição"));
        objAcao.setPontosGerados(inteiro("Pontos Gerados"));

        System.out.println(Acaodao.inserir(objAcao));

        //RESGATE
        ResgateDao ResgateDao = new ResgateDao();
        Resgate objResgate = new Resgate();

        objResgate.setIdResgate(inteiro("ID do Resgate"));
        objResgate.setQuantidadePonto(inteiro("Quantidade de pontos"));
        objResgate.setValorCredito(numero("Valor de Credito"));
        objResgate.setStatus(texto("Status"));

        System.out.println(ResgateDao.inserir(objResgate));

        //TRANSPORTE
        TransporteDao TransporteDao = new TransporteDao();
        Transporte objTransporte = new Transporte();

        objTransporte.setIdTransporte(inteiro("Id do Transporte"));
        objTransporte.setTipoTransporte(texto("Tipo do Transporte"));
        objTransporte.setNomeCartao(texto("Nome do cartão"));
        objTransporte.setOperadora(texto("Operadora"));

        System.out.println(TransporteDao.inserir(objTransporte));
    }
}
