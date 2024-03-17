package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/vagas")
public class ParkingSpaceController {
    private ParkingSpaceRepository repository;

    public ParkingSpaceController(ParkingSpaceRepository repository) {
        this.repository = repository;
    }

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
