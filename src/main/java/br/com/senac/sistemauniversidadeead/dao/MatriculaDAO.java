package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.Matricula;
import br.com.senac.sistemauniversidadeead.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    public void cadastrarMatricula(Matricula matricula) {

        String sql = "INSERT INTO matricula "
                + "(nome_aluno, cpf_aluno, data, telefone) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula.getNomeAluno());
            stmt.setString(2, matricula.getCpfAluno());
            stmt.setDate(3, java.sql.Date.valueOf(matricula.getData()));
            stmt.setString(4, matricula.getTelefone());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Matricula> listarMatriculas() {

        List<Matricula> matriculas = new ArrayList<>();

        String sql = "SELECT * FROM matricula";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Matricula matricula = new Matricula();

                matricula.setId(rs.getInt("id"));
                matricula.setNomeAluno(rs.getString("nome_aluno"));
                matricula.setCpfAluno(rs.getString("cpf_aluno"));
                matricula.setData(
                        rs.getDate("data").toLocalDate()
                );
                matricula.setTelefone(rs.getString("telefone"));

                matriculas.add(matricula);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matriculas;
    }

    public void excluirMatricula(int id) {

        String sql = "DELETE FROM matricula WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}