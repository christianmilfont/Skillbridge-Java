package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.time.LocalDateTime;
@Entity @Table(name = "PERFIS") @Data @NoArgsConstructor @AllArgsConstructor public class Perfil {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "PERFIL_ID")private Long id;

    @OneToOne@JoinColumn(name = "USUARIO_ID", unique = true, nullable = false)private Usuario usuario;

    @Column(name = "RESUMO", length = 1000)private String resumo;

    @Column(name = "ULTIMA_ATUALIZACAO")private LocalDateTime ultimaAtualizacao;
}