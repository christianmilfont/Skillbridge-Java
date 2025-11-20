package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.time.LocalDateTime;
@Entity @Table(name = "COMPATIBILIDADE") @Data @NoArgsConstructor @AllArgsConstructor public class Compatibilidade {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;

    @ManyToOne@JoinColumn(name = "USUARIO_ID", nullable = false)private Usuario usuario;

    @ManyToOne@JoinColumn(name = "VAGA_ID", nullable = false)private Vaga vaga;

    @Column(name = "PORCENTAGEM", nullable = false)private Integer porcentagem;

    @Column(name = "MELHOR", nullable = false)private Boolean melhor;

    @Column(name = "GERADO_EM")private LocalDateTime geradoEm;
}