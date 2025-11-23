package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.CandidatoDTO;
import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import com.example.SkillBridge.dto.VagaCompatibilidadeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IoTService {

    // SIMULA dados vindo do sensor / python / IA
    public IoTResponseWrapperDTO buscarDadosDoIoT() {

        IoTResponseWrapperDTO wrapper = new IoTResponseWrapperDTO();
        List<CandidatoDTO> candidatos = new ArrayList<>();

        // ---- Candidato 1 ----
        CandidatoDTO c1 = new CandidatoDTO();
        c1.setId(1L);
        c1.setNome("João Silva");

        VagaCompatibilidadeDTO melhor1 = new VagaCompatibilidadeDTO(
                101L,
                "Desenvolvedor Backend Júnior",
                87
        );
        c1.setMelhorVaga(melhor1);

        List<VagaCompatibilidadeDTO> todas1 = new ArrayList<>();
        todas1.add(melhor1);
        todas1.add(new VagaCompatibilidadeDTO(102L, "DevOps Assistente", 75));
        todas1.add(new VagaCompatibilidadeDTO(103L, "Tester QA Júnior", 62));

        c1.setTodasAsVagas(todas1);
        candidatos.add(c1);


        // ---- Candidato 2 ----
        CandidatoDTO c2 = new CandidatoDTO();
        c2.setId(2L);
        c2.setNome("Maria Costa");

        VagaCompatibilidadeDTO melhor2 = new VagaCompatibilidadeDTO(
                102L,
                "Desenvolvedor Backend Senior",
                88
        );
        c2.setMelhorVaga(melhor2);

        List<VagaCompatibilidadeDTO> todas2 = new ArrayList<>();
        todas2.add(melhor2);
        todas2.add(new VagaCompatibilidadeDTO(202L, "UX Designer Junior", 70));
        todas2.add(new VagaCompatibilidadeDTO(203L, "Product Owner", 55));

        c2.setTodasAsVagas(todas2);
        candidatos.add(c2);


        wrapper.setCandidatos(candidatos);
        return wrapper;
    }

    // MOCK: não faz nada, só imprime
    public void processarDadosDoIoT(IoTResponseDTO dto) {
        System.out.println("Mock IoT processando dados para o usuário " + dto.getNome());
    }
}
