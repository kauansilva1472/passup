package br.com.soulpass.entities;

public class Usuario {

    private int idUsuario;
    private String nome;
    private String email;
    private int saldoPontos;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String email, int saldoPontos) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.saldoPontos = saldoPontos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSaldoPontos() {
        return saldoPontos;
    }

    public void setSaldoPontos(int saldoPontos) {
        this.saldoPontos = saldoPontos;
    }

    @Override
    public String toString() {
        return "\n\n Usuario " +
                "\n idUsuario = " + idUsuario +
                "\n nome = " + nome +
                "\n email = " + email +
                "\n saldoPontos = " + saldoPontos;
    }
}

