package com.example.SkillBridge.controller;

import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.service.AnaliseService;
import com.example.SkillBridge.service.IoTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/iot")
public class IoTController {

    private final IoTService ioTService;
    private final AnaliseService analiseService;

    public IoTController(IoTService ioTService, AnaliseService analiseService) {
        this.ioTService = ioTService;
        this.analiseService = analiseService;
    }

    @PostMapping("/vaga")
    public ResponseEntity<String> receberDadosIoT(@RequestBody IoTResponseDTO dto) {
        ioTService.processarDadosDoIoT(dto);
        return ResponseEntity.ok("Dados recebidos e processados com sucesso.");
    }

    @GetMapping("/sincronizar")
    public ResponseEntity<String> sincronizar() {
        analiseService.sincronizarAnalise();
        return ResponseEntity.ok("Dados sincronizados com sucesso!");
    }
}
