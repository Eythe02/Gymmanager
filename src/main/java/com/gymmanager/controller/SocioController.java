package com.gymmanager.controller;

import com.gymmanager.model.Socio;
import com.gymmanager.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService service;

    @GetMapping
    public List<Socio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Socio create(@RequestBody Socio socio) {
        return service.save(socio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Socio> update(@PathVariable Long id, @RequestBody Socio nuevo) {
        return service.findById(id)
                .map(s -> {
                    s.setNombre(nuevo.getNombre());
                    s.setEdad(nuevo.getEdad());
                    s.setEmail(nuevo.getEmail());
                    return ResponseEntity.ok(service.save(s));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(s -> {
                    service.delete(id);
                    return ResponseEntity.<Void>noContent().build();
                })
                .orElse(ResponseEntity.<Void>notFound().build());
    }

    @GetMapping("/{id}/total-clases")
    public Long totalClases(@PathVariable Long id) {
        return service.contarClases(id);
    }
}
