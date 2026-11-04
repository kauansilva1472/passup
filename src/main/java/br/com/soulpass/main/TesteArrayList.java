package br.com.soulpass.main;

import br.com.soulpass.entities.Acao;
import br.com.soulpass.entities.Resgate;
import br.com.soulpass.entities.Transporte;
import br.com.soulpass.entities.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class TesteArrayList {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double numero(String j){
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {

        ArrayList<Acao> acoes= new ArrayList<>();
        ArrayList<Resgate> resgates= new ArrayList<>();
        ArrayList<Transporte> transportes= new ArrayList<>();
        ArrayList<Usuario> usuarios= new ArrayList<>();

        Acao objacao = null;
        Resgate objresgate = null;
        Transporte objtransporte = null;
        Usuario objusuario = null;

        do {
            //int idUsuario, String nome, String email, int saldoPontos
            objusuario = new Usuario();
            objusuario.setIdUsuario(inteiro("Digite o ID do usuário:"));
            objusuario.setNome(texto("Digite o nome do usuário:"));
            objusuario.setEmail(texto("Digite o e-mail do usuário:"));
            objusuario.setSaldoPontos(inteiro("Digite o saldo de pontos do usuário:"));

            usuarios.add(objusuario);

        }while (JOptionPane.showConfirmDialog(null,"Deseja cadastrar outro usuário?",
                "Cadastro de Usuário",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== 0);
        for (Usuario U: usuarios)
            System.out.println(
                    "\n\nID Usuário = " + U.getIdUsuario() +
                            "\n Nome = " + U.getNome() +
                            "\n Email = " + U.getEmail() +
                            "\n Saldo de Pontos = " + U.getSaldoPontos()
            );

        do {
            //int idAcao, String nomeAcao, String descricao, int pontosGerados//
            objacao = new Acao();
            objacao.setIdAcao(inteiro("Digite o ID da ação:"));
            objacao.setNomeAcao(texto("Digite o nome da ação:"));
            objacao.setDescricao(texto("Digite a descrição da ação:"));
            objacao.setPontosGerados(inteiro("Digite a quantidade de pontos gerados:"));

            acoes.add(objacao);

        }while (JOptionPane.showConfirmDialog(null,"Deseja cadastrar outra ação?",
                "Cadastro de Ação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== 0);
        for (Acao A: acoes)
            System.out.println(
                    "\n\nID Ação = " + A.getIdAcao()  +
                            "\n Nome da Ação = " + A.getNomeAcao() +
                            "\n Descrição = " + A.getDescricao() +
                            "\n Pontos Gerados = " + A.getPontosGerados()
        );

        do {
            //int idResgate, int quantidadePonto, double valorCredito, String status
            objresgate = new Resgate();
            objresgate.setIdResgate(inteiro("Digite o ID do resgate:"));
            objresgate.setQuantidadePonto(inteiro("Digite a quantidade de pontos do resgate:"));
            int sandoUsuario = usuarios.get(0).getSaldoPontos();
            objresgate.setValorCredito(objresgate.calcularCredito());
            objresgate.setStatus(objresgate.atualizarStatus(sandoUsuario));
            if (objresgate.verificarSaldo(sandoUsuario)) {
                int novoSaldo = objresgate.descontarPontos(sandoUsuario);
                usuarios.get(0).setSaldoPontos(novoSaldo);
            }

            resgates.add(objresgate);

        }while (JOptionPane.showConfirmDialog(null,"Deseja cadastrar outro resgate?",
                "Cadastro de Resgate",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== 0);
        for (Resgate R: resgates)
            System.out.println(
                    "\n\nID Resgate = " + R.getIdResgate()  +
                            "\n Quantidade de Pontos = " + R.getQuantidadePonto() +
                            "\n Valor do Crédito R$ = " + R.getValorCredito() +
                            "\n Status = " + R.getStatus()
            );

        do {
            //int idTransporte, String tipoTransporte, String nomeCartao, String operadora
            objtransporte = new Transporte();
            objtransporte.setIdTransporte(inteiro("Digite o ID do transporte:"));
            objtransporte.setTipoTransporte(texto("Digite o tipo de transporte:"));
            objtransporte.setNomeCartao(texto("Digite o nome do cartão:"));
            objtransporte.setOperadora(texto("Digite o nome da operadora:"));

            transportes.add(objtransporte);

        }while (JOptionPane.showConfirmDialog(null,"Deseja cadastrar outro transporte?",
                "Cadastro de Transporte",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== 0);
        for (Transporte T: transportes)
            System.out.println(
                    "\n\nID Transporte = " + T.getIdTransporte()+
                            "\n Tipo de Transporte = " + T.getTipoTransporte() +
                            "\n Nome do Cartão= " + T.getNomeCartao() +
                            "\n Operadora = " + T.getOperadora()
            );
    }
}
