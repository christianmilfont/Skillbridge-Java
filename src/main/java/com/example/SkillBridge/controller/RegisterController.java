package com.example.SkillBridge.controller;

import com.example.SkillBridge.dto.RegisterDTO;
import com.example.SkillBridge.model.Usuario;
import com.example.SkillBridge.repository.UsuarioRepository;
import com.example.SkillBridge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class RegisterController {

    private final UsuarioService usuarioService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public RegisterController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Exibe página de registro
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO()); // Passa o DTO para o Thymeleaf
        return "user/register"; // templates/user/register.html
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Salva novo usuário
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDTO dto) {
        if (dto.getSenha() == null || dto.getSenha().isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenhaHash(encoder.encode(dto.getSenha()));

        usuario.setRole(Usuario.Role.USER); // SEMPRE USER
        usuario.setCriadoEm(LocalDateTime.now());

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}
