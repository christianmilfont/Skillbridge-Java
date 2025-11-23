package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.*;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    private final IoTService ioTService;
    private final AIService aiService;

    public AnaliseService(IoTService ioTService, AIService aiService) {
        this.ioTService = ioTService;
        this.aiService = aiService;
    }

    public IoTResponseWrapperDTO buscarAnaliseLocal() {
        return ioTService.buscarDadosDoIoT();
    }

    public IoTResponseWrapperDTO sincronizarAnalise() {

        IoTResponseWrapperDTO wrapper = ioTService.buscarDadosDoIoT();

        if (wrapper != null && wrapper.getCandidatos() != null) {

            for (CandidatoDTO candidato : wrapper.getCandidatos()) {

                // Converter melhor vaga (VagaCompatibilidadeDTO → MelhorVagaDTO)
                MelhorVagaDTO melhor = new MelhorVagaDTO();
                melhor.setVagaId(candidato.getMelhorVaga().getVagaId());
                melhor.setVagaNome(candidato.getMelhorVaga().getVagaNome());
                melhor.setCompatibilidade(candidato.getMelhorVaga().getCompatibilidade());

                IoTResponseDTO dto = new IoTResponseDTO();
                dto.setId(candidato.getId());
                dto.setNome(candidato.getNome());
                dto.setMelhorVaga(melhor); // agora o tipo está correto
                dto.setTodasAsVagas(candidato.getTodasAsVagas());

                // Geração de descrição pela IA
                // Geração de descrição pela IA
                String descricao = aiService.gerarDescricaoMelhorVaga(
                        melhor.getVagaNome(),
                        melhor.getCompatibilidade()
                );


        // salva a descrição também no objeto ORIGINAL usado pelo Thymeleaf
                candidato.getMelhorVaga().setDescricao(descricao);

        // salva no DTO interno (opcional)
                melhor.setDescricao(descricao);
                dto.setDescricao(descricao);


                ioTService.processarDadosDoIoT(dto);
            }
        }

        return wrapper;
    }
}
