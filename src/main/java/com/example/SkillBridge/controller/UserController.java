package com.example.SkillBridge.controller;

import com.example.SkillBridge.model.Usuario;
import com.example.SkillBridge.repository.CompatibilidadeRepository;
import com.example.SkillBridge.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/user")  // Prefixo "/user" para ações gerais do usuário
public class UserController {

    private final UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Exibe ou edita o perfil do usuário
    @GetMapping("/perfil")
    public String perfil(Model model) {
        // Recupera o usuário logado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario == null) {
            return "error/404"; // Se o usuário não for encontrado, mostra a página de erro
        }

        model.addAttribute("usuario", usuario);
        return "user/perfil";  // Exibe o template do perfil
    }

    // Outros métodos de ações gerais do usuário, como editar perfil ou informações pessoais
}
