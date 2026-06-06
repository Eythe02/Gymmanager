package com.gymmanager.repository;

import com.gymmanager.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("SELECT COUNT(c) FROM Socio s JOIN s.clases c WHERE s.id = :id")
    Long contarClases(@Param("id") Long id);    
}
