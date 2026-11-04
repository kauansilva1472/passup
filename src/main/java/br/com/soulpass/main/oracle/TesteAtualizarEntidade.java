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

public class TesteAtualizarEntidade {

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

        int opcao = inteiro("\n\n Escolha o que deseja atualizar:" +
                "\n1 Usuario" +
                "\n2 Acao" +
                "\n3 Resgate" +
                "\n4 Transporte ");

        switch (opcao) {
            case 1:
                UsuarioDao dao = new UsuarioDao();
                Usuario objUsuario = new Usuario();

                objUsuario.setIdUsuario(
                        inteiro("Informe o codigo do Usuario que sera atualizado")
                );

                objUsuario.setNome(texto("Nome"));
                objUsuario.setEmail(texto("Email"));
                objUsuario.setSaldoPontos(inteiro("Saldo Pontos"));

                System.out.println(dao.atualizar(objUsuario));
                break;
            case 2:
                AcaoDao Acaodao = new AcaoDao();
                Acao objAcao = new Acao();

                objAcao.setIdAcao(inteiro("Informe o ID da acao que sera Atualizado"));
                objAcao.setNomeAcao(texto("Nome ação"));
                objAcao.setDescricao(texto("Descrição"));
                objAcao.setPontosGerados(inteiro("Pontos Gerados"));

                System.out.println(Acaodao.atualizar(objAcao));
                break;
            case 3:
                ResgateDao ResgateDao = new ResgateDao();
                Resgate objResgate = new Resgate();

                objResgate.setIdResgate(inteiro("Informe o ID do Resgate que sera Atualizado"));
                objResgate.setQuantidadePonto(inteiro("Quantidade de pontos"));
                objResgate.setValorCredito(numero("Valor de Credito"));
                objResgate.setStatus(texto("Status"));

                System.out.println(ResgateDao.atualizar(objResgate));
                break;
            case 4:
                TransporteDao TransporteDao = new TransporteDao();
                Transporte objTransporte = new Transporte();

                objTransporte.setIdTransporte(inteiro("Informe o Id do Transporte que sera atualizado "));
                objTransporte.setTipoTransporte(texto("Tipo do Transporte"));
                objTransporte.setNomeCartao(texto("Nome do cartão"));
                objTransporte.setOperadora(texto("Operadora"));

                System.out.println(TransporteDao.atualizar(objTransporte));
                break;
            default:
                JOptionPane.showInternalMessageDialog(null, "Opcao invalida");

        }
    }
}
