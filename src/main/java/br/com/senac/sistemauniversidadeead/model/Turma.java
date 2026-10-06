package br.com.senac.sistemauniversidadeead.model;

public class Turma {

    private int id;
    private String codigo;
    private String periodo;
    private int ano;

    private Curso curso;
    private Professor professor;

    public Turma() {
    }

    public Turma(int id, String codigo, String periodo, int ano,
                 Curso curso, Professor professor) {

        this.id = id;
        this.codigo = codigo;
        this.periodo = periodo;
        this.ano = ano;
        this.curso = curso;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}