package com.example.SkillBridge.dto;

import java.util.List;

import lombok.Data;
@Data
public class CandidatoDTO {
    private Long id;
    private String nome;
    private MelhorVagaDTO melhor_vaga;
    private List<VagaCompatibilidadeDTO> todas_as_vagas;

    
}