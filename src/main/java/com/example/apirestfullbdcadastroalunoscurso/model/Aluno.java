package com.example.apirestfullbdcadastroalunoscurso.model;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Construtor
    public Aluno() {}

    public Aluno(Long id, String nome, int idade, String email, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.curso = curso;
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEmail() { return email; }
    public Curso getCurso() { return curso; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEmail(String email) { this.email = email; }
    public void setCurso(Curso curso) { this.curso = curso; }
}
