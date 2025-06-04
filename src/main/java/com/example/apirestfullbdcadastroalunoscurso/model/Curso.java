package com.example.apirestfullbdcadastroalunoscurso.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String area;

    //@OneToMany(mappedBy = curso )
    //private List<Aluno> alunos;

    // Construtor
    public Curso() {}

    public Curso(Long id, String nome,String area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getArea() { return area; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setArea(String area) { this.area = area; }
}
