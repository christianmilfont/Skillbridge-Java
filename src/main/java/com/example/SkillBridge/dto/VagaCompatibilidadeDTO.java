package com.example.SkillBridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VagaCompatibilidadeDTO {

    @JsonProperty("vaga_id")
    private Long vagaId;

    @JsonProperty("vaga_nome")
    private String vagaNome;

    private Integer compatibilidade;
    public VagaCompatibilidadeDTO(Long vagaId, String vagaNome, int compatibilidade) {
        this.vagaId = vagaId;
        this.vagaNome = vagaNome;
        this.compatibilidade = compatibilidade;
    }

}
