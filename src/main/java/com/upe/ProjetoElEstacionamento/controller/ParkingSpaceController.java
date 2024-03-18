package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.Services.ParkingSpaceService;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking_space")
public class ParkingSpaceController {
    private ParkingSpaceRepository spaceRepository;
    private ParkingSpaceService spaceService;

    public ParkingSpaceController(ParkingSpaceRepository spaceRepository, ParkingSpaceService spaceService) {
        this.spaceRepository = spaceRepository;
        this.spaceService = spaceService;
    }

    @CrossOrigin
    @GetMapping
    public List<ParkingSpace> getAll() {
        return spaceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getSpaceById(@PathVariable Long id) {
        ParkingSpace space = spaceRepository.findById(id)
                .orElse(null);
        if (space != null) {
            return ResponseEntity.ok(space);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Double> getPayment(@PathVariable Long id){
        Double payment = spaceService.payment(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
