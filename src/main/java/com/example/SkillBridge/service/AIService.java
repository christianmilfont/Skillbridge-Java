package com.example.SkillBridge.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    private final PythonIntegrationService pythonService;
    private final IoTService ioTService;
    private final AIService aiService;

    public AnaliseService(PythonIntegrationService pythonService,
                          IoTService ioTService,
                          AIService aiService) {
        this.pythonService = pythonService;
        this.ioTService = ioTService;
        this.aiService = aiService;
    }

    public IoTResponseWrapperDTO buscarAnalisePython() {
        return pythonService.buscarAnaliseDoPython();
    }

    public void sincronizarAnalisePython() {
        IoTResponseWrapperDTO wrapper = pythonService.buscarAnaliseDoPython();

        if (wrapper != null && wrapper.getCandidatos() != null) {

            for (CandidatoDTO candidato : wrapper.getCandidatos()) {

                IoTResponseDTO dto = new IoTResponseDTO();
                dto.setId(candidato.getId());
                dto.setNome(candidato.getNome());
                dto.setMelhor_vaga(candidato.getMelhor_vaga());
                dto.setTodas_as_vagas(candidato.getTodas_as_vagas());

                // ✔ Geração de descrição pela IA
                if (candidato.getMelhor_vaga() != null) {

                    String titulo = candidato.getMelhor_vaga().getTitulo(); // CONFIRMAR
                    int compatibilidade = candidato.getMelhor_vaga().getCompatibilidade();

                    String descricao = aiService.gerarDescricaoMelhorVaga(titulo, compatibilidade);

                    // só funciona se seu DTO tiver esse setter
                    candidato.getMelhor_vaga().setDescricao(descricao);
                }

                ioTService.processarDadosDoIoT(dto);
            }
        }
    }
}

