package com.example.SkillBridge.model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "USUARIO_COMPETENCIAS")
public class UsuarioCompetencia {

    @EmbeddedId
    private UsuarioCompetenciaId id;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @ManyToOne
    @MapsId("competenciaId")
    @JoinColumn(name = "COMPETENCIA_ID")
    private Competencia competencia;

    @Column(name = "NIVEL_PONTUACAO", nullable = false)
    private Double nivelPontuacao;



}