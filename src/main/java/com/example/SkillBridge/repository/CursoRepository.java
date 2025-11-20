package com.example.SkillBridge.repository;

import com.example.SkillBridge.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CursoRepository extends JpaRepository<Curso, Long> {
}