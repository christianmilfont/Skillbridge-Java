package com.example.SkillBridge.model;

import jakarta.persistence.*;import lombok.*;import java.time.LocalDateTime;
@Entity @Table(name = "APP_AUDITORIA") @Data @NoArgsConstructor @AllArgsConstructor public class AppAuditoria {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "AUDITORIA_ID")private Long id;

    @Column(name = "NOME_TABELA", nullable = false, length = 50)private String nomeTabela;

    @Column(name = "OPERACAO", nullable = false, length = 10)private String operacao;

    @Column(name = "DADOS_ANTIGOS", columnDefinition = "TEXT")private String dadosAntigos;

    @Column(name = "DADOS_NOVOS", columnDefinition = "TEXT")private String dadosNovos;

    @Column(name = "ALTERADO_POR", length = 100)private String alteradoPor;

    @Column(name = "DATA_ALTERACAO")private LocalDateTime dataAlteracao;
}