package com.gymmanager.repository;

import com.gymmanager.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    List<Clase> findByNombreContainingIgnoreCase(String nombre);

    List<Clase> findByEntrenadorId(Long id);
}

