package org.example.model;

public class Estudante {
    private int estudanteId;
    private String nome;
    private int idade;

    public Estudante() {
    }

    public Estudante(int idade, String nome, int estudanteId) {
        this.idade = idade;
        this.nome = nome;
        this.estudanteId = estudanteId;
    }

    public int getEstudanteId() {
        return estudanteId;
    }

    public void setEstudanteId(int estudanteId) {
        this.estudanteId = estudanteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "estudanteId=" + estudanteId +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
