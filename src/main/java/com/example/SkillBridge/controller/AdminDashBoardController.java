package com.example.SkillBridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashBoardController {

    // Página principal do administrador
    @GetMapping("")
    public String dashboardAdmin() {
        return "admin/dashboard";
    }

    // Exemplo: gerenciar usuários
    @GetMapping("/usuarios")
    public String gerenciarUsuarios() {
        return "admin/usuarios";
    }

    // Exemplo: analisar desempenho
    @GetMapping("/analytics")
    public String analyticsAdmin() {
        return "admin/analytics";
    }
}
