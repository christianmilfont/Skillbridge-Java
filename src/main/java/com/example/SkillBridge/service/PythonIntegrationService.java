package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PythonIntegrationService {

    private final WebClient webClient;

    public PythonIntegrationService() {
        this.webClient = WebClient.builder()
                .baseUrl("") // URL do Flask
                .build();
    }

    public IoTResponseWrapperDTO buscarAnaliseDoPython() {
        return webClient.get()
                .uri("/analise")
                .retrieve()
                .bodyToMono(IoTResponseWrapperDTO.class)
                .block(); // bloqueia até receber a resposta
    }
}
