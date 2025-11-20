package com.example.SkillBridge.service;

import com.example.SkillBridge.model.Competencia;
import com.example.SkillBridge.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class CompetenciaService {

    private final CompetenciaRepository repository;

    public CompetenciaService(CompetenciaRepository repository) {
        this.repository = repository;
    }

    public Competencia salvar(Competencia competencia) {
        return repository.save(competencia);
    }

    public List<Competencia> listar() {
        return repository.findAll();
    }

    public Competencia buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}