package com.example.SkillBridge.dto;

import lombok.Data;import java.util.List;
@Data public class IoTResponseDTO {

    private Long id;
    private MelhorVagaDTO melhor_vaga;
    private List<VagaCompatibilidadeDTO> todas_as_vagas;
}