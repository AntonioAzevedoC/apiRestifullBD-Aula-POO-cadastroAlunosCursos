package com.example.apirestfullbdcadastroalunoscurso.repository;

import com.example.apirestfullbdcadastroalunoscurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
