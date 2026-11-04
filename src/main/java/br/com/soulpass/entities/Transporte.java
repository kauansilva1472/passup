package br.com.soulpass.entities;

public class Transporte {

   private int idTransporte;
   private String tipoTransporte;
   private String nomeCartao;
   private String operadora;

    public Transporte() {
    }

    public Transporte(int idTransporte, String tipoTransporte, String nomeCartao, String operadora) {
        this.idTransporte = idTransporte;
        this.tipoTransporte = tipoTransporte;
        this.nomeCartao = nomeCartao;
        this.operadora = operadora;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "\n\n Transporte " +
                "\n idTransporte = " + idTransporte +
                "\n tipoTransporte = " + tipoTransporte +
                "\n nomeCartao = " + nomeCartao +
                "\n operadora = " + operadora;
    }
}
