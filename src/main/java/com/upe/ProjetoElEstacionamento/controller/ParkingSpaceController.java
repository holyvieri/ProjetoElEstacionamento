package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estacionamento")
public class ParkingSpaceController {
    private ParkingSpaceRepository repository;

    public ParkingSpaceController(ParkingSpaceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ParkingSpace> getAll() {
        return repository.findAll();
    }

}
