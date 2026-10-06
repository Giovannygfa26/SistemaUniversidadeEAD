package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.Curso;
import br.com.senac.sistemauniversidadeead.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void cadastrarCurso(Curso curso) {

        String sql = "INSERT INTO curso (nome, descricao, carga_horaria) "
                   + "VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getCargaHoraria());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listarCursos() {

        List<Curso> cursos = new ArrayList<>();

        String sql = "SELECT id, nome, descricao, carga_horaria "
                   + "FROM curso ORDER BY id";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Curso curso = new Curso();

                curso.setId(resultado.getInt("id"));
                curso.setNome(resultado.getString("nome"));
                curso.setDescricao(resultado.getString("descricao"));
                curso.setCargaHoraria(
                        resultado.getInt("carga_horaria")
                );

                cursos.add(curso);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public void excluirCurso(int id) {

        String sql = "DELETE FROM curso WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}