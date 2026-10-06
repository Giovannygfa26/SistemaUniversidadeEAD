package br.com.senac.sistemauniversidadeead.dao;

import br.com.senac.sistemauniversidadeead.model.TipoUsuario;
import br.com.senac.sistemauniversidadeead.model.Usuario;
import br.com.senac.sistemauniversidadeead.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario autenticar(String login, String senha) {

        String sql = "SELECT * FROM usuario "
                + "WHERE login = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                usuario.setTipo(
                        TipoUsuario.valueOf(
                                rs.getString("tipo").toUpperCase()
                        )
                );

                return usuario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
