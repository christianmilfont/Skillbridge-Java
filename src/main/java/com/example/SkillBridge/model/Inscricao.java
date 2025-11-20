package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.time.LocalDateTime;
@Entity @Table(name = "INSCRICOES") @Data @NoArgsConstructor @AllArgsConstructor public class Inscricao {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "INSCRICAO_ID")private Long id;

    @ManyToOne@JoinColumn(name = "USUARIO_ID", nullable = false)private Usuario usuario;

    @ManyToOne@JoinColumn(name = "CURSO_ID", nullable = false)private Curso curso;

    @Column(name = "DATA_INSCRICAO")private LocalDateTime dataInscricao;

    @Column(name = "STATUS", length = 20)private String status;
}