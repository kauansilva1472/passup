package br.com.soulpass.entities;

public class Resgate {

    private int idResgate;
    private int quantidadePonto;
    private double valorCredito;
    private String status;

    public Resgate() {
    }

    public Resgate(int idResgate, int quantidadePonto, double valorCredito, String status) {
        this.idResgate = idResgate;
        this.quantidadePonto = quantidadePonto;
        this.valorCredito = valorCredito;
        this.status = status;
    }

    public boolean  verificarSaldo(int saldoPontos){
        if (saldoPontos >= quantidadePonto){
            return true;
        }else{
            return false;
        }
    }

    public double calcularCredito(){
        return quantidadePonto / 100.0;
    }

    public int descontarPontos(int saldoPontos){
        return saldoPontos - quantidadePonto;
    }

    public String atualizarStatus(int saldoPontos){
        if (saldoPontos >= quantidadePonto ) {
            return "APROVADO";
        }else{
            return "RECUSADO";
        }
    }



    public int getIdResgate() {
        return idResgate;
    }

    public void setIdResgate(int idResgate) {
        this.idResgate = idResgate;
    }

    public int getQuantidadePonto() {
        return quantidadePonto;
    }

    public void setQuantidadePonto(int quantidadePonto) {
        this.quantidadePonto = quantidadePonto;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n\n Resgate " +
                "\n idResgate = " + idResgate +
                "\n quantidadePonto = " + quantidadePonto +
                "\n valorCredito = " + valorCredito +
                "\n status = " + status ;
    }
}



