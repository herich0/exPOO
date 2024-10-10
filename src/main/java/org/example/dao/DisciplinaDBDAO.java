package org.example.dao;

import org.example.model.Disciplina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDBDAO implements DisciplinaDAO {

    @Override
    public void insere(Disciplina disciplina) throws SQLException {
        Connection connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        String sql = "INSERT INTO Disciplina (Disciplina_ID, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, disciplina.getDisciplinaId());
            stmt.setString(2, disciplina.getNome());
            stmt.executeUpdate();
        }
    }

    @Override
    public void atualiza(Disciplina disciplina) throws SQLException {
        Connection connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        String sql = "UPDATE Disciplina SET nome = ? WHERE Disciplina_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getDisciplinaId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void remove(Disciplina disciplina) throws SQLException {
        Connection connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        String sql = "DELETE FROM Disciplina WHERE Disciplina_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, disciplina.getDisciplinaId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Disciplina buscaPorCodigo(int codigo) throws SQLException {
        Connection connection = Conexao.getConexao();
        String sql = "SELECT * FROM Disciplina WHERE Disciplina_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Disciplina(rs.getInt("Disciplina_ID"), rs.getString("nome"));
            }
        }
        return null;
    }

    @Override
    public List<Disciplina> listaTodos() throws SQLException {
        Connection connection = Conexao.getConexao();
        String sql = "SELECT * FROM Disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                disciplinas.add(new Disciplina(rs.getInt("Disciplina_ID"), rs.getString("nome")));
            }
        }
        return disciplinas;
    }
}
