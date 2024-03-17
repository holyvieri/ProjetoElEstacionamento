package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/vagas")
public class ParkingSpaceController {
    private ParkingSpaceRepository repository;

    public ParkingSpaceController(ParkingSpaceRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping
    public List<ParkingSpace> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getSpaceById(@PathVariable Long id) {
        ParkingSpace space = repository.findById(id)
                .orElse(null);
        if (space != null) {
            return ResponseEntity.ok(space);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
