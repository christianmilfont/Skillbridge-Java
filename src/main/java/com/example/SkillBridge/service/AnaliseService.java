package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.CandidatoDTO;
import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
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

    public IoTResponseWrapperDTO sincronizarAnalisePython() {

        IoTResponseWrapperDTO wrapper = pythonService.buscarAnaliseDoPython();

        if (wrapper != null && wrapper.getCandidatos() != null) {

            for (CandidatoDTO candidato : wrapper.getCandidatos()) {

                IoTResponseDTO dto = new IoTResponseDTO();
                dto.setId(candidato.getId());
                dto.setNome(candidato.getNome());
                dto.setMelhorVaga(candidato.getMelhorVaga());
                dto.setTodasAsVagas(candidato.getTodasAsVagas());

                // ✔ Geração de descrição pela IA
                if (candidato.getMelhorVaga() != null) {

                    String titulo = candidato.getMelhorVaga().getVagaNome();
                    int compatibilidade = candidato.getMelhorVaga().getCompatibilidade();

                    String descricao = aiService.gerarDescricaoMelhorVaga(titulo, compatibilidade);

                    candidato.getMelhorVaga().setDescricao(descricao);
                }

                ioTService.processarDadosDoIoT(dto);
            }
        }

        return wrapper;
    }
}
