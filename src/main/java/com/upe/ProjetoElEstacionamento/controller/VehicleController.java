package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Services.ParkingSpaceService;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.Services.VehicleService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleRepository vehicleRepository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private final VehicleService vehicleService;
    private ParkingSpaceService parkingSpaceService;
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
    @CrossOrigin
    @PostMapping("/create") //estacionar
    public ResponseEntity<Long> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Long newVehicle_id = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle_id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não há como deletar o veículo, pois o ID do veículo especificado não foi encontrado."));
        vehicleService.removeVehicleFromSpace(id);
        return ResponseEntity.ok().build();
    }
}
