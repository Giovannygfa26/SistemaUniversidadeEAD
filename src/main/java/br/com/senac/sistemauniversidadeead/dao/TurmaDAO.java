package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.Curso;
import br.com.senac.sistemauniversidadeead.model.Professor;
import br.com.senac.sistemauniversidadeead.model.Turma;
import br.com.senac.sistemauniversidadeead.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    public void cadastrarTurma(Turma turma) {

        String sql = "INSERT INTO turma "
                + "(codigo, periodo, ano, curso_id, professor_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, turma.getCodigo());
            stmt.setString(2, turma.getPeriodo());
            stmt.setInt(3, turma.getAno());
            stmt.setInt(4, turma.getCurso().getId());
            stmt.setInt(5, turma.getProfessor().getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Turma> listarTurmas() {

        List<Turma> turmas = new ArrayList<>();

        String sql = "SELECT "
                + "t.id, "
                + "t.codigo, "
                + "t.periodo, "
                + "t.ano, "
                + "c.id AS curso_id, "
                + "c.nome AS curso_nome, "
                + "p.id AS professor_id, "
                + "p.nome AS professor_nome "
                + "FROM turma t "
                + "INNER JOIN curso c ON t.curso_id = c.id "
                + "INNER JOIN professor p ON t.professor_id = p.id "
                + "ORDER BY t.id";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Turma turma = new Turma();

                turma.setId(resultado.getInt("id"));
                turma.setCodigo(resultado.getString("codigo"));
                turma.setPeriodo(resultado.getString("periodo"));
                turma.setAno(resultado.getInt("ano"));

                Curso curso = new Curso();
                curso.setId(resultado.getInt("curso_id"));
                curso.setNome(resultado.getString("curso_nome"));

                Professor professor = new Professor();
                professor.setId(resultado.getInt("professor_id"));
                professor.setNome(resultado.getString("professor_nome"));

                turma.setCurso(curso);
                turma.setProfessor(professor);

                turmas.add(turma);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return turmas;
    }

    public void excluirTurma(int id) {

        String sql = "DELETE FROM turma WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}