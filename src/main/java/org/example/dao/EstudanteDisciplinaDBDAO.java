package org.example.dao;

import org.example.model.EstudanteDisciplina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDisciplinaDBDAO {

    public void insere(EstudanteDisciplina estudanteDisciplina) throws SQLException {
        Connection connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        String sql = "INSERT INTO EstudanteDisciplina (Estudante_ID, Disciplina_ID) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estudanteDisciplina.getEstudante().getEstudanteId());
            stmt.setInt(2, estudanteDisciplina.getDisciplina().getDisciplinaId());
            stmt.executeUpdate();
        }
    }

    public List<EstudanteDisciplina> listaTodos() throws SQLException {
        Connection connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
        String sql = "SELECT * FROM EstudanteDisciplina";
        List<EstudanteDisciplina> estudanteDisciplinas = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                EstudanteDisciplina estudanteDisciplina = new EstudanteDisciplina();
                estudanteDisciplina.setEstudante(new EstudanteDBDAO().buscaPorCodigo(rs.getInt("Estudante_ID")));
                estudanteDisciplina.setDisciplina(new DisciplinaDBDAO().buscaPorCodigo(rs.getInt("Disciplina_ID")));
                estudanteDisciplinas.add(estudanteDisciplina);
            }
        }
        return estudanteDisciplinas;
    }
}
