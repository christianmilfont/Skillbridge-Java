package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.util.List;
@Entity @Table(name = "VAGAS") @Data @NoArgsConstructor @AllArgsConstructor public class Vaga {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "VAGA_ID")private Long id;

    @Column(name = "TITULO", nullable = false, length = 150)private String titulo;

    @Column(name = "DESCRICAO", columnDefinition = "TEXT")private String descricao;

    @Column(name = "REQUISITOS", length = 1000)private String requisitos;

    @OneToMany(mappedBy = "vaga")private List<Compatibilidade> compatibilidades;
}