package org.example.dao;

import org.example.model.Disciplina;
import java.sql.SQLException;
import java.util.List;

public interface DisciplinaDAO {
    void insere(Disciplina disciplina) throws SQLException;
    void atualiza(Disciplina disciplina) throws SQLException;
    void remove(Disciplina disciplina) throws SQLException;
    Disciplina buscaPorCodigo(int codigo) throws SQLException;
    List<Disciplina> listaTodos() throws SQLException;
}
