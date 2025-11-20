package com.example.SkillBridge.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioCompetenciaId implements Serializable {

    private Long usuarioId;
    private Long competenciaId;

    public UsuarioCompetenciaId() {}

    public UsuarioCompetenciaId(Long usuarioId, Long competenciaId) {
        this.usuarioId = usuarioId;
        this.competenciaId = competenciaId;
    }

    // Getters e Setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(Long competenciaId) {
        this.competenciaId = competenciaId;
    }

    // hashCode e equals obrigatórios para chave composta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioCompetenciaId)) return false;
        UsuarioCompetenciaId that = (UsuarioCompetenciaId) o;
        return Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(competenciaId, that.competenciaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, competenciaId);
    }
}