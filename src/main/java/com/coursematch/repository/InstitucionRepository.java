package com.coursematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coursematch.entity.Institucion;

public interface InstitucionRepository extends JpaRepository<Institucion, Long> {

}
