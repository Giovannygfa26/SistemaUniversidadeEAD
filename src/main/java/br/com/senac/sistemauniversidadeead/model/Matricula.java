package br.com.senac.sistemauniversidadeead.model;

import java.time.LocalDate;

public class Matricula {

    private int id;
    private String nomeAluno;
    private String cpfAluno;
    private LocalDate data;
    private String telefone;

    public Matricula() {
    }

    public Matricula(int id, String nomeAluno, String cpfAluno,
                     LocalDate data, String telefone) {

        this.id = id;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.data = data;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}