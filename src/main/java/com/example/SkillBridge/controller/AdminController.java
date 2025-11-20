package com.example.SkillBridge.controller;

import com.example.SkillBridge.model.*;
import com.example.SkillBridge.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsuarioService usuarioService;
    private final VagaService vagaService;
    private final CursoService cursoService;
    private final CompetenciaService competenciaService;

    public AdminController(UsuarioService usuarioService,
                           VagaService vagaService,
                           CursoService cursoService,
                           CompetenciaService competenciaService) {
        this.usuarioService = usuarioService;
        this.vagaService = vagaService;
        this.cursoService = cursoService;
        this.competenciaService = competenciaService;
    }

    // ===== Usuários =====
    @GetMapping("/usuarios")public String listarUsuarios(Model model) {
    List<Usuario> usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "admin/usuarios";
}

@GetMapping("/usuarios/novo")
public String novoUsuarioForm(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "admin/usuario-form";
}

@PostMapping("/usuarios/salvar")
public String salvarUsuario(@ModelAttribute Usuario usuario) {
    usuarioService.salvar(usuario);
    return "redirect:/admin/usuarios";
}

@GetMapping("/usuarios/editar/{id}")
public String editarUsuario(@PathVariable Long id, Model model) {
    Usuario usuario = usuarioService.buscarPorId(id);
    model.addAttribute("usuario", usuario);
    return "admin/usuario-form";
}

@GetMapping("/usuarios/deletar/{id}")
public String deletarUsuario(@PathVariable Long id) {
    usuarioService.deletar(id);
    return "redirect:/admin/usuarios";
}

// ===== Vagas =====
@GetMapping("/vagas")public String listarVagas(Model model) {
List<Vaga> vagas = vagaService.listar();
        model.addAttribute("vagas", vagas);
        return "admin/vagas";
                }

@GetMapping("/vagas/novo")
public String novaVagaForm(Model model) {
    model.addAttribute("vaga", new Vaga());
    return "admin/vaga-form";
}

@PostMapping("/vagas/salvar")
public String salvarVaga(@ModelAttribute Vaga vaga) {
    vagaService.salvar(vaga);
    return "redirect:/admin/vagas";
}

@GetMapping("/vagas/editar/{id}")
public String editarVaga(@PathVariable Long id, Model model) {
    Vaga vaga = vagaService.buscarPorId(id);
    model.addAttribute("vaga", vaga);
    return "admin/vaga-form";
}

@GetMapping("/vagas/deletar/{id}")
public String deletarVaga(@PathVariable Long id) {
    vagaService.deletar(id);
    return "redirect:/admin/vagas";
}

// ===== Cursos =====
@GetMapping("/cursos")public String listarCursos(Model model) {
List<Curso> cursos = cursoService.listar();
        model.addAttribute("cursos", cursos);
        return "admin/cursos";
                }

@GetMapping("/cursos/novo")
public String novoCursoForm(Model model) {
    model.addAttribute("curso", new Curso());
    return "admin/curso-form";
}

@PostMapping("/cursos/salvar")
public String salvarCurso(@ModelAttribute Curso curso) {
    cursoService.salvar(curso);
    return "redirect:/admin/cursos";
}

@GetMapping("/cursos/editar/{id}")
public String editarCurso(@PathVariable Long id, Model model) {
    Curso curso = cursoService.buscarPorId(id);
    model.addAttribute("curso", curso);
    return "admin/curso-form";
}

@GetMapping("/cursos/deletar/{id}")
public String deletarCurso(@PathVariable Long id) {
    cursoService.deletar(id);
    return "redirect:/admin/cursos";
}

// ===== Competências =====
@GetMapping("/competencias")
public String listarCompetencias(Model model) {
List<Competencia> competencias = competenciaService.listar();
        model.addAttribute("competencias", competencias);
        return "admin/competencias";
                }

@GetMapping("/competencias/novo")
public String novaCompetenciaForm(Model model) {
    model.addAttribute("competencia", new Competencia());
    return "admin/competencia-form";
}

@PostMapping("/competencias/salvar")
public String salvarCompetencia(@ModelAttribute Competencia competencia) {
    competenciaService.salvar(competencia);
    return "redirect:/admin/competencias";
}

@GetMapping("/competencias/editar/{id}")
public String editarCompetencia(@PathVariable Long id, Model model) {
    Competencia competencia = competenciaService.buscarPorId(id);
    model.addAttribute("competencia", competencia);
    return "admin/competencia-form";
}

@GetMapping("/competencias/deletar/{id}")
public String deletarCompetencia(@PathVariable Long id) {
    competenciaService.deletar(id);
    return "redirect:/admin/competencias";
}
}