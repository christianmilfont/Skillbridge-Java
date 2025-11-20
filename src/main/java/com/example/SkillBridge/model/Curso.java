package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.util.List;
@Entity @Table(name = "CURSOS") @Data @NoArgsConstructor @AllArgsConstructor public class Curso {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "CURSO_ID")private Long id;

    @Column(name = "TITULO", nullable = false, length = 150)private String titulo;

    @Column(name = "DESCRICAO", length = 500)private String descricao;

    @Column(name = "DURACAO_HORAS")private Double duracaoHoras;

    @OneToMany(mappedBy = "curso")private List<Inscricao> inscricoes;
}