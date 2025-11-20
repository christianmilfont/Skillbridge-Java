package com.example.SkillBridge.service;

import com.example.SkillBridge.model.Vaga;
import com.example.SkillBridge.repository.VagaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service public class VagaService {

    private final VagaRepository repository;

    public VagaService(VagaRepository repository) {
        this.repository = repository;
    }

    public Vaga salvar(Vaga vaga) {
        return repository.save(vaga);
    }

    public List<Vaga> listar() {
        return repository.findAll();
    }

    public Vaga buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}