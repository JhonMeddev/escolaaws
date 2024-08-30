package com.escolaaws.model;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;
    private float notaPrimeiroSemestre;
    private float notaSegundoSemestre;
    private String nomeProfessor;
    private int numeroSala;

    public Aluno() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public float getNotaPrimeiroSemestre() {
        return notaPrimeiroSemestre;
    }

    public void setNotaPrimeiroSemestre(float notaPrimeiroSemestre) {
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
    }

    public float getNotaSegundoSemestre() {
        return notaSegundoSemestre;
    }

    public void setNotaSegundoSemestre(float notaSegundoSemestre) {
        this.notaSegundoSemestre = notaSegundoSemestre;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}

