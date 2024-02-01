package com.demo.atenea.demo.repository;

import com.demo.atenea.demo.domain.Area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
 
}