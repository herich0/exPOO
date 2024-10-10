package org.example.dao;

import org.example.model.Estudante;
import java.sql.SQLException;
import java.util.List;

public interface EstudanteDAO {
    void insere(Estudante estudante) throws SQLException;
    void atualiza(Estudante estudante) throws SQLException;
    void remove(Estudante estudante) throws SQLException;
    Estudante buscaPorCodigo(int codigo) throws SQLException;
    List<Estudante> listaTodos() throws SQLException;
}
