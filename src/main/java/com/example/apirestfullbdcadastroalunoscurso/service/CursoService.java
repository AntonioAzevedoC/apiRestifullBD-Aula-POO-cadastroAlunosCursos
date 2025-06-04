package com.example.apirestfullbdcadastroalunoscurso.service;

import com.example.apirestfullbdcadastroalunoscurso.model.Curso;
import com.example.apirestfullbdcadastroalunoscurso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    // Injection
    CursoRepository cursoRepository;

    // Constructor
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Método para mostrar todos os curso
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    // Método para pesquisar curso
    public Curso getCurso(Long id) {
        return cursoRepository.findById(id).get();
    }

    // Método para inserir novo curso
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método para atualizar curso já existente
    public Curso updateCurso(Long id, Curso curso) {
        Curso recuperado = cursoRepository.findById(id).orElse(null);

        // Caso aluno encontrado
        if (recuperado != null) {
            recuperado.setNome(curso.getNome());
            recuperado.setArea(curso.getArea());
            cursoRepository.save(recuperado); // Como o Id é o mesmo, substituir original
            return recuperado;
        }
        return null; // Aluno não encontrado
    }
}
