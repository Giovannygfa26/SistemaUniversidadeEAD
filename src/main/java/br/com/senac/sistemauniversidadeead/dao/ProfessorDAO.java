package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.Professor;
import br.com.senac.sistemauniversidadeead.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void cadastrarProfessor(Professor professor) {

        String sql = "INSERT INTO professor "
                + "(nome, cpf, email, telefone) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getTelefone());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Professor> listarProfessores() {

        List<Professor> professores = new ArrayList<>();

        String sql = "SELECT id, nome, cpf, email, telefone "
                + "FROM professor ORDER BY id";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Professor professor = new Professor();

                professor.setId(resultado.getInt("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setCpf(resultado.getString("cpf"));
                professor.setEmail(resultado.getString("email"));
                professor.setTelefone(resultado.getString("telefone"));

                professores.add(professor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return professores;
    }

    public void excluirProfessor(int id) {

        String sql = "DELETE FROM professor WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}