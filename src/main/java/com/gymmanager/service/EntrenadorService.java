package com.gymmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gymmanager.model.Entrenador;
import com.gymmanager.repository.EntrenadorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository repository;

    public List<Entrenador> findAll() {
        return repository.findAll();
    }

    public Optional<Entrenador> findById(Long id) {
        return repository.findById(id);
    }

    public Entrenador save(Entrenador entrenador) {
        return repository.save(entrenador);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
