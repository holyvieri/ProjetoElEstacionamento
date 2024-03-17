package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.services.VehicleService;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/veiculo")
public class VehicleController {
    private VehicleRepository vehicleRepository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private VehicleService vehicleService;
    public VehicleController(VehicleRepository vehicleRepository, VehicleService vehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
    }

    //GETs - O primeira retorna todos e o segundo retorna apenas um objeto pelo Id
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

    //POST - vai receber um JSON do front para criar um objeto Vehicle
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle newVehicle = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle);

    }

    // DELETE - vai deletar o objeto pelo Id
    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deleteVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.removeVehicleFromSpace(vehicleDTO.getParkingSpace().getId());
        return ResponseEntity.ok().build();
    }
}
