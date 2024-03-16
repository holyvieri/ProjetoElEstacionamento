package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.Services.VehicleService;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/registro")
public class VehicleController {
    private VehicleRepository repository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private VehicleService vehicleService;
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> veiculos = repository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    //vai receber JSON do front

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        Vehicle vehicle = vehicleService.findVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
