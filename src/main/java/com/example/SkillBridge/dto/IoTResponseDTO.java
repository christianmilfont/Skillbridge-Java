package com.example.SkillBridge.dto;

import lombok.Data;
import java.util.List;
@Data 
public class IoTResponseDTO {

    private Long id;
    private String nome;                    

    private MelhorVagaDTO melhor_vaga;
    private String descricao;

    private List<VagaCompatibilidadeDTO> todas_as_vagas;
}