package com.gymmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gymmanager.model.Clase;
import com.gymmanager.repository.ClaseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaseService {

    private final ClaseRepository repository;

    public List<Clase> findAll() {
        return repository.findAll();
    }

    public Optional<Clase> findById(Long id) {
        return repository.findById(id);
    }

    public Clase save(Clase clase) {
        return repository.save(clase);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Clase> buscar(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Clase> findByEntrenador(Long id) {
        return repository.findByEntrenadorId(id);
    }
}
