package com.example.SkillBridge.model;
import jakarta.persistence.*;import lombok.*;import java.time.LocalDateTime;import java.util.List;
@Entity @Table(name = "USUARIOS") @Data @NoArgsConstructor @AllArgsConstructor public class Usuario {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "USUARIO_ID")private Long id;

    @Column(name = "NOME", nullable = false, length = 100)private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)private String email;

    @Column(name = "SENHA_HASH", nullable = false, length = 255)private String senhaHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    //criação da classe role posteriormente, deixando mais objetiva a classe User por enquanto
    public enum Role{
        ADMIN,
        USER
    };

    @Column(name = "CRIADO_EM")private LocalDateTime criadoEm;

    /** RELACIONAMENTOS **/@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)private Perfil perfil;

    @OneToMany(mappedBy = "usuario")private List<UsuarioCompetencia> competencias;

    @OneToMany(mappedBy = "usuario")private List<Inscricao> inscricoes;

    @OneToMany(mappedBy = "usuario")private List<Compatibilidade> compatibilidades;
}