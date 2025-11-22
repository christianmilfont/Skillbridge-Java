package com.example.SkillBridge.service;

import com.example.SkillBridge.dto.CandidatoDTO;
import com.example.SkillBridge.dto.IoTResponseDTO;
import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    private final PythonIntegrationService pythonService;
    private final IoTService ioTService;

    public AnaliseService(PythonIntegrationService pythonService, IoTService ioTService) {
        this.pythonService = pythonService;
        this.ioTService = ioTService;
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

                ioTService.processarDadosDoIoT(dto);
            }
        }
    }
}
