package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.util.List;
@Entity @Table(name = "COMPETENCIAS") @Data @NoArgsConstructor @AllArgsConstructor public class Competencia {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "COMPETENCIA_ID")private Long id;

    @Column(name = "NOME", nullable = false, length = 100, unique = true)private String nome;

    @Column(name = "DESCRICAO", length = 500)private String descricao;

    @OneToMany(mappedBy = "competencia")private List<UsuarioCompetencia> usuarios;
}