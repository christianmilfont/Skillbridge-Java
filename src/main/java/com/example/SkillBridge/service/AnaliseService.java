package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.CandidatoDTO;
import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    private final PythonIntegrationService pythonService;
    private final IoTService ioTService;
    private final AIService aiService; // injetando AIService para gerar descrições

    public AnaliseService(PythonIntegrationService pythonService,
                          IoTService ioTService,
                          AIService aiService) {
        this.pythonService = pythonService;
        this.ioTService = ioTService;
        this.aiService = aiService;
    }

    public IoTResponseWrapperDTO buscarAnalisePython() {
        return pythonService.buscarAnaliseDoPython(); // retorna o JSON do Flask
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

                // ✅ Gerar descrição de compatibilidade para a melhor vaga
                if (candidato.getMelhor_vaga() != null) {
                    String descricao = aiService.gerarDescricaoMelhorVaga(
                        candidato.getMelhor_vaga().getTitulo(), 
                        candidato.getMelhor_vaga().getCompatibilidade()
                    );
                    candidato.getMelhor_vaga().setDescricao(descricao); // se MelhorVagaDTO tiver campo descricao
                }

                ioTService.processarDadosDoIoT(dto);
            }
        }
    }
}
