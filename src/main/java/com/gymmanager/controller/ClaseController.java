package com.gymmanager.controller;

import com.gymmanager.model.Clase;
import com.gymmanager.service.ClaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
@RequiredArgsConstructor
public class ClaseController {

    private final ClaseService service;

    @GetMapping
    public List<Clase> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clase create(@RequestBody Clase clase) {
        return service.save(clase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> update(@PathVariable Long id, @RequestBody Clase nuevo) {
        return service.findById(id)
                .map(c -> {
                    c.setNombre(nuevo.getNombre());
                    c.setDuracion(nuevo.getDuracion());
                    c.setEntrenador(nuevo.getEntrenador());
                    return ResponseEntity.ok(service.save(c));
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
                .orElse(ResponseEntity.<Void>notFound().build());
    }

    @GetMapping("/buscar")
    public List<Clase> buscar(@RequestParam(required = false, defaultValue = "") String nombre) {
        return service.buscar(nombre);
    }

    @GetMapping("/entrenador/{id}")
    public List<Clase> porEntrenador(@PathVariable Long id) {
        return service.findByEntrenador(id);
    }
}
