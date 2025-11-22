package com.example.SkillBridge.dto;

import java.util.List;

public class IoTResponseWrapperDTO {

    private List<CandidatoDTO> candidatos;

    // Getter
    public List<CandidatoDTO> getCandidatos() {
        return candidatos;
    }

    // Setter
    public void setCandidatos(List<CandidatoDTO> candidatos) {
        this.candidatos = candidatos;
    }
}
