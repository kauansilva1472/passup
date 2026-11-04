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
import java.util.ArrayList;

public class TesteSelecionarEntidade {

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        int opcao = inteiro(
                "\nEscolha o que deseja selecionar:" +
                        "\n1 - Usuario" +
                        "\n2 - Acao" +
                        "\n3 - Resgate" +
                        "\n4 - Transporte"
        );
        switch (opcao) {
            case 1:
                UsuarioDao usuarioDao = new UsuarioDao();

                ArrayList<Usuario> listaUsuario =
                        (ArrayList<Usuario>) usuarioDao.selecionar();
                if (listaUsuario != null) {
                    for (Usuario u : listaUsuario) {
                        System.out.println(
                                u.getIdUsuario() + " | " +
                                        u.getNome() + " | " +
                                        u.getEmail() + " | " +
                                        u.getSaldoPontos());
                    }
                }break;
            case 2:
                AcaoDao acaoDao = new AcaoDao();

                ArrayList<Acao> listaAcao =
                        (ArrayList<Acao>) acaoDao.selecionar();
                if (listaAcao != null) {
                    for (Acao a : listaAcao) {
                        System.out.println(
                                a.getIdAcao() + " | " +
                                        a.getNomeAcao() + " | " +
                                        a.getDescricao() + " | " +
                                        a.getPontosGerados());
                    }
                }
                break;
            case 3:
                ResgateDao resgateDao = new ResgateDao();

                ArrayList<Resgate> listaResgate =
                        (ArrayList<Resgate>) resgateDao.selecionar();
                if (listaResgate != null) {
                    for (Resgate r : listaResgate) {
                        System.out.println(
                                r.getIdResgate() + " | " +
                                        r.getQuantidadePonto() + " | " +
                                        r.getValorCredito() + " | " +
                                        r.getStatus());
                    }
                }
                break;
            case 4:
                TransporteDao transporteDao = new TransporteDao();

                ArrayList<Transporte> listaTransporte =
                        (ArrayList<Transporte>) transporteDao.selecionar();
                if (listaTransporte != null) {
                    for (Transporte t : listaTransporte) {
                        System.out.println(
                                t.getIdTransporte() + " | " +
                                        t.getTipoTransporte() + " | " +
                                        t.getNomeCartao() + " | " +
                                        t.getOperadora());
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao invalida");
        }
    }
}
