package com.example.SkillBridge.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IoTResponseDTO {

    private Long id;
    private String nome;

    @JsonProperty("melhor_vaga")
    private MelhorVagaDTO melhorVaga;

    private String descricao;

    @JsonProperty("todas_as_vagas")
    private List<VagaCompatibilidadeDTO> todasAsVagas;

}
