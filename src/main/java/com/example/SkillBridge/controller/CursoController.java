package com.example.SkillBridge.controller;

import com.example.SkillBridge.model.Curso;
import com.example.SkillBridge.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Listar todos os cursos
    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.buscarTodos());
        return "admin/cursos";
    }

    // Mostrar formulário para criar curso
    @GetMapping("/novo")
    public String novoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "admin/form-curso";
    }

    // Salvar novo curso
    @PostMapping("/salvar")
    public String salvarCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.salvar(curso);
        return "redirect:/admin/cursos";
    }

    // Deletar curso
    @GetMapping("/deletar/{id}")
    public String deletarCurso(@PathVariable("id") Long id) {
        cursoService.deletar(id);
        return "redirect:/admin/cursos";
    }
}
