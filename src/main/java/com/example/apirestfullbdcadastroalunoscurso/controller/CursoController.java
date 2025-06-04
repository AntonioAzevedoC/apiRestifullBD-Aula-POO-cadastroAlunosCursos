package com.example.apirestfullbdcadastroalunoscurso.controller;

import com.example.apirestfullbdcadastroalunoscurso.model.Curso;
import com.example.apirestfullbdcadastroalunoscurso.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    CursoService cursoService;

    // Constructor
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Get mapping, método para listar todos os cursos
    @GetMapping
    public List<Curso> listarCurso() {
        return cursoService.getCursos();
    }

    // Get mapping, método para mostrar dados de um curso
    @GetMapping("/{id}")
    public Curso mostrarCurso(@PathVariable Long id) {
        return cursoService.getCurso(id);
    }

    // Post mapping, método para adicionar um curso
    @PostMapping
    public Curso cadastrarCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    // Put mapping, método para atualizar dados de curso
    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.updateCurso(id, curso);
    }
}
