package com.example.SkillBridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }
    @GetMapping("/minhas-vagas")
    public String userVagas(Model model) {
        // Aqui você pode adicionar a lógica para exibir as vagas do usuário
        return "user/minhas_vagas";  // Retorna o template com as vagas do usuário
    }
}
