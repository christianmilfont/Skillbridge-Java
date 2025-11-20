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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")  // Prefixo "/painel/user" para as informações do painel
public class UserDashBoardController {

    private final CompatibilidadeRepository compatibilidadeRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public UserDashBoardController(CompatibilidadeRepository compatibilidadeRepository, UsuarioService usuarioService) {
        this.compatibilidadeRepository = compatibilidadeRepository;
        this.usuarioService = usuarioService;
    }

    // Exibe o dashboard com informações do usuário, compatibilidade, etc.
    @GetMapping("/board")
    public String userDashboard(Model model) {
        // Recupera o usuário logado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        Usuario usuario = usuarioService.buscarPorEmail(email);



        // Busca compatibilidade do usuário com as vagas
        var compatibilidades = compatibilidadeRepository.findByUsuarioId(usuario.getId());
        //var melhorVaga = compatibilidades.stream().findFirst().orElse(null);

        model.addAttribute("usuario", usuario);
        model.addAttribute("compatibilidades", compatibilidades);
        model.addAttribute("melhorVaga");

        return "user/board";  // Exibe o template do dashboard
    }

    // Exibe as vagas relacionadas ao usuário


    // Exibe as informações dos cursos relacionados ao usuário
    @GetMapping("/meus-cursos")
    public String userCursos(Model model) {
        // Aqui você pode adicionar a lógica para exibir os cursos do usuário
        return "user/meus_cursos";  // Retorna o template com os cursos do usuário
    }
}
