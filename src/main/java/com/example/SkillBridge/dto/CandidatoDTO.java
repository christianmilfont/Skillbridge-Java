package com.example.SkillBridge.dto;

import java.util.List;

public class CandidatoDTO {
    private Long id;
    private String nome;
    private MelhorVagaDTO melhor_vaga;
    private List<VagaCompatibilidadeDTO> todas_as_vagas;

    // GETTERS e SETTERS CORRETOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public MelhorVagaDTO getMelhor_vaga() { return melhor_vaga; }
    public void setMelhor_vaga(MelhorVagaDTO melhor_vaga) { this.melhor_vaga = melhor_vaga; }

    public List<VagaCompatibilidadeDTO> getTodas_as_vagas() { return todas_as_vagas; }
    public void setTodas_as_vagas(List<VagaCompatibilidadeDTO> todas_as_vagas) { this.todas_as_vagas = todas_as_vagas; }

}