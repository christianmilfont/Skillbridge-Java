package com.example.SkillBridge.controller;

import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import com.example.SkillBridge.service.AnaliseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class AnaliseViewController {

    private final AnaliseService analiseService;

    public AnaliseViewController(AnaliseService analiseService) {
        this.analiseService = analiseService;
    }

    @GetMapping("/analise")
    public String viewAnalise(Model model) {
        IoTResponseWrapperDTO wrapper = analiseService.buscarAnalisePython(); // chama Flask
        model.addAttribute("candidatos", wrapper.getCandidatos());
        return "user/analise"; // corresponde ao arquivo analise.html em resources/templates
    }
}
