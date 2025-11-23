package com.example.SkillBridge.controller;

import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import com.example.SkillBridge.model.Usuario;
import com.example.SkillBridge.repository.CompatibilidadeRepository;
import com.example.SkillBridge.service.AnaliseService;
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
    private final AnaliseService analiseService;
    @Autowired
    public UserController(UsuarioService usuarioService, AnaliseService analiseService) {
        this.usuarioService = usuarioService;
        this.analiseService = analiseService;
    }
        @GetMapping("/lista")
        public String listarUsuarios(Model model) {
            // Recupera todos os usuários
            var usuarios = usuarioService.buscarTodos();
            model.addAttribute("usuarios", usuarios);
            return "admin/usuarios"; // Template Thymeleaf
        }
    // Exibe ou edita o perfil do usuário
    @GetMapping("/perfil")
    public String perfil(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario == null) {
            return "error/404";
        }

        model.addAttribute("usuario", usuario);

        IoTResponseWrapperDTO wrapper = analiseService.sincronizarAnalise();

        wrapper.getCandidatos().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(usuario.getNome()))
                .findFirst()
                .ifPresent(candidato -> {
                    model.addAttribute("melhorVaga", candidato.getMelhorVaga());
                    model.addAttribute("todasVagas", candidato.getTodasAsVagas());
                });

        return "user/perfil";
    }


    // Outros métodos de ações gerais do usuário, como editar perfil ou informações pessoais
}
