package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.Services.VehicleService;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/registro")
public class VehicleController {
    private VehicleRepository vehicleRepository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private VehicleService vehicleService;
    public VehicleController(VehicleRepository vehicleRepository, VehicleService vehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
    }

    //GET
    @GetMapping  //esse tá pegando
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> veiculos = vehicleRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElse(null);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //POST
    //vai receber JSON do front - DTO
    @PostMapping("/criar")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle newVehicle = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle);

    }
    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deleteVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.removeVehicleFromSpace(vehicleDTO.getParkingSpace().getId());
        return ResponseEntity.ok().build();
    }
}
