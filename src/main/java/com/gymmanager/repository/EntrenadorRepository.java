package com.gymmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymmanager.model.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}

