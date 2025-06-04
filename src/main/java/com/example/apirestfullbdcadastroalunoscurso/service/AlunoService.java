package com.example.apirestfullbdcadastroalunoscurso.service;

import com.example.apirestfullbdcadastroalunoscurso.model.Aluno;
import com.example.apirestfullbdcadastroalunoscurso.model.Curso;
import com.example.apirestfullbdcadastroalunoscurso.repository.AlunoRepository;
import com.example.apirestfullbdcadastroalunoscurso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    // Injection
    AlunoRepository alunoRepository;
    CursoRepository cursoRepository;

    // Constructor
    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    // Método para mostrar todos os aluno
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    // Método para pesquisar aluno
    public Aluno getAluno(Long id) {
        return alunoRepository.findById(id).get();
    }

    // Método para inserir novo aluno
    public Aluno saveAluno(Aluno aluno) {
        // Procurando por curso
        Curso aux = cursoRepository.findById(aluno.getCurso().getId()).orElse(null);
        if (aux != null){ // caso curso sejá encontrado, inserir curso
            aluno.setCurso(aux);
            return alunoRepository.save(aluno);
        }
        // Caso o curso não seja encontrado
        return alunoRepository.save(aluno);
    }

    // Método para atualizar aluno já existente
    public Aluno updateAluno(Long id, Aluno aluno) {
        Aluno recuperado = alunoRepository.findById(id).orElse(null);

        // Caso aluno encontrado
        if (recuperado != null) {
            recuperado.setNome(aluno.getNome());
            recuperado.setIdade(aluno.getIdade());
            recuperado.setEmail(aluno.getEmail());
            recuperado.setCurso(aluno.getCurso());
            alunoRepository.save(recuperado); // Como o Id é o mesmo, substituir original
            return recuperado;
        }
        return null; // Aluno não encontrado
    }

    // Método para remover aluno
    public String deleteAluno(Long id) {
        if (alunoRepository.existsById(id)) { // delete aluno where id = "id"
            alunoRepository.deleteById(id);
            return "Aluno Removido com sucesso";
        }
        return "Aluno Não encontrado";
    }
}
