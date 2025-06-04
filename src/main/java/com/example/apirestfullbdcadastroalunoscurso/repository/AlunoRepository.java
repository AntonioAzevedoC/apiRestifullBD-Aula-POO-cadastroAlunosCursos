package com.example.apirestfullbdcadastroalunoscurso.repository;

import com.example.apirestfullbdcadastroalunoscurso.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
