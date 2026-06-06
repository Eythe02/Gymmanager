package com.gymmanager.controller;

import com.gymmanager.model.Entrenador;
import com.gymmanager.service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService service;

    @GetMapping
    public List<Entrenador> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return service.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador nuevo) {
        return service.findById(id)
                .map(e -> {
                    e.setNombre(nuevo.getNombre());
                    e.setEspecialidad(nuevo.getEspecialidad());
                    return ResponseEntity.ok(service.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

  @DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    return service.findById(id)
            .map(c -> {
                service.delete(id);
                return ResponseEntity.<Void>noContent().build();
            })
            .orElse(ResponseEntity.<Void>notFound().build()); // <-- add <Void> here
}
}
