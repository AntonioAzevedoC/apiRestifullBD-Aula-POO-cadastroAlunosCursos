package com.example.apirestfullbdcadastroalunoscurso.controller;

import com.example.apirestfullbdcadastroalunoscurso.model.Aluno;
import com.example.apirestfullbdcadastroalunoscurso.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunoService alunoService;

    // Constructor
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Get mapping, método para listar todos os alunos
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.getAlunos();
    }

    // Get mapping, método para mostrar dados de um aluno
    @GetMapping("/{id}")
    public Aluno mostrarAluno(@PathVariable Long id) {
        return alunoService.getAluno(id);
    }

    // Post mapping, método para adicionar um aluno
    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }

    // Delete mapping, método para remover um aluno
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }

    // Put mapping, método para atualizar dados de aluno
    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(id, aluno);
    }
}
