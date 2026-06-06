package com.gymmanager.service;

import com.gymmanager.model.Socio;
import com.gymmanager.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SocioService {

    private final SocioRepository repository;

    public List<Socio> findAll() {
        return repository.findAll();
    }

    public Optional<Socio> findById(Long id) {
        return repository.findById(id);
    }

    public Socio save(Socio socio) {
        return repository.save(socio);
    }
}