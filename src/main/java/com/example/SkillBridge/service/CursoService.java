package com.example.SkillBridge.service;

import com.example.SkillBridge.model.Curso;
import com.example.SkillBridge.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}