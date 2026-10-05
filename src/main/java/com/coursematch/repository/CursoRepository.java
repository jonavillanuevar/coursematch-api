package com.coursematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coursematch.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
