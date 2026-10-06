package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.Material;
import br.com.senac.sistemauniversidadeead.model.Professor;
import br.com.senac.sistemauniversidadeead.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void cadastrarMaterial(Material material) {

        String sql = "INSERT INTO material "
                + "(nome, tipo, descricao, professor_id) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, material.getNome());
            stmt.setString(2, material.getTipo());
            stmt.setString(3, material.getDescricao());
            stmt.setInt(4, material.getProfessor().getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> listarMateriais() {

        List<Material> materiais = new ArrayList<>();

        String sql = "SELECT "
                + "m.id, "
                + "m.nome, "
                + "m.tipo, "
                + "m.descricao, "
                + "p.id AS professor_id, "
                + "p.nome AS professor_nome "
                + "FROM material m "
                + "INNER JOIN professor p "
                + "ON m.professor_id = p.id "
                + "ORDER BY m.id";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Material material = new Material();

                material.setId(resultado.getInt("id"));
                material.setNome(resultado.getString("nome"));
                material.setTipo(resultado.getString("tipo"));
                material.setDescricao(resultado.getString("descricao"));

                Professor professor = new Professor();

                professor.setId(resultado.getInt("professor_id"));
                professor.setNome(resultado.getString("professor_nome"));

                material.setProfessor(professor);

                materiais.add(material);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return materiais;
    }

    public void excluirMaterial(int id) {

        String sql = "DELETE FROM material WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}