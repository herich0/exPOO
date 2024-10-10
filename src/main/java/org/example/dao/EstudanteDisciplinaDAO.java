package org.example.dao;

import org.example.model.Estudante;

import java.sql.SQLException;
import java.util.List;

public interface EstudanteDisciplinaDAO {
    public void insere(Estudante estudante);
    public void atualiza (Estudante estudante);
    public void remove (Estudante estudante);
    public Estudante buscaPorCodigo(int EstudanteId) throws SQLException;
    public List<Estudante> listaTodos() throws SQLException;
}
