package br.com.soulpass.entities;

public class Acao {

    private int idAcao;
    private  String nomeAcao;
    private String descricao;
    private int pontosGerados;

    public Acao() {
    }

    public Acao(int idAcao, String nomeAcao, String descricao, int pontosGerados) {
        this.idAcao = idAcao;
        this.nomeAcao = nomeAcao;
        this.descricao = descricao;
        this.pontosGerados = pontosGerados;
    }

    public int getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(int idAcao) {
        this.idAcao = idAcao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontosGerados() {
        return pontosGerados;
    }

    public void setPontosGerados(int pontosGerados) {
        this.pontosGerados = pontosGerados;
    }

    @Override
    public String toString() {
        return "\n\n Acao " +
                "\n idAcao = " + idAcao +
                "\n nomeAcao = " + nomeAcao +
                "\n descricao = " + descricao +
                "\n pontosGerados = " + pontosGerados;
    }
}



