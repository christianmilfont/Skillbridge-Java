package com.example.SkillBridge.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CandidatoDTO {

    private Long id;
    private String nome;

    @JsonProperty("melhor_vaga")
    private VagaCompatibilidadeDTO  melhorVaga;

    @JsonProperty("todas_as_vagas")
    private List<VagaCompatibilidadeDTO> todasAsVagas;

}
