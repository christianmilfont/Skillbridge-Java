package com.example.SkillBridge.controller;

import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.service.IoTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iot")
public class IoTController {

    private final IoTService ioTService;

    public IoTController(IoTService ioTService) {
        this.ioTService = ioTService;
    }

    @PostMapping("/vaga")
    public ResponseEntity<String> receberDadosIoT(@RequestBody IoTResponseDTO dto) {

        ioTService.processarDadosDoIoT(dto);

        return ResponseEntity.ok("Dados recebidos e processados com sucesso.");
    }
}
