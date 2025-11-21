package com.example.SkillBridge.service;
import org.springframework.stereotype.Service;
import com.example.SkillBridge.dto.IoTResponseWrapperDTO;
import com.example.SkillBridge.service.PythonIntegrationService;
import com.example.SkillBridge.service.IoTService;
import com.example.SkillBridge.dto.CandidatoDTO;
import com.example.SkillBridge.dto.IoTResponseDTO;


@Service
public class AnaliseService {

    private final PythonIntegrationService pythonService;
    private final IoTService ioTService;

    public AnaliseService(PythonIntegrationService pythonService, IoTService ioTService) {
        this.pythonService = pythonService;
        this.ioTService = ioTService;
    }

    public void sincronizarAnalisePython() {
        IoTResponseWrapperDTO wrapper = pythonService.buscarAnaliseDoPython();

        if (wrapper != null && wrapper.getCandidatos() != null) {
            for (var candidato : wrapper.getCandidatos()) {
                // transforma CandidatoDTO em IoTResponseDTO para reaproveitar o service
                ioTService.processarDadosDoIoT(candidato);
            }
        }
    }
}
