package com.demo.atenea.demo.repository;

import com.demo.atenea.demo.domain.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
 
}