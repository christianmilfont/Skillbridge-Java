package com.example.SkillBridge.service;

import com.example.SkillBridge.model.Usuario;
import com.example.SkillBridge.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Salva ou atualiza um usuário
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    // Busca por ID
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Busca por email (para login e perfil)
    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    // Verifica se existe um usuário com esse email
    public boolean existsByEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
    // Lista todos
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // Deleta usuário por ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
