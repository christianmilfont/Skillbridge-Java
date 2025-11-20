package com.example.SkillBridge.repository;

import com.example.SkillBridge.model.Compatibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;import java.util.Optional;
public interface CompatibilidadeRepository extends JpaRepository<Compatibilidade, Long> {

    List<Compatibilidade> findByUsuarioId(Long usuarioId);

    Optional<Compatibilidade> findByUsuarioIdAndVagaId(Long usuarioId, Long vagaId);

    void deleteByUsuarioId(Long usuarioId);
}