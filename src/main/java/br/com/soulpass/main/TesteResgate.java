package br.com.soulpass.main;

import br.com.soulpass.entities.Resgate;

public class TesteResgate {

    public static void main(String[] args) {

        Resgate resgate1 = new Resgate();

        resgate1.setQuantidadePonto(300);

        int saldoUsuario = 1000;

        System.out.println(resgate1.verificarSaldo(saldoUsuario));
        System.out.println(resgate1.calcularCredito());
        System.out.println(resgate1.descontarPontos(saldoUsuario));
        System.out.println(resgate1.atualizarStatus(saldoUsuario));
    }
}
