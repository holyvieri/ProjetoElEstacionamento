package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento/registro")
public class VehicleController {
    private VehicleRepository repository;
    private ParkingSpaceRepository parkingSpaceRepository;
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> veiculos = repository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    //vai receber JSON do front com as seguintes infos: owner_name, licensePlate, preferential, vehicleType
    @PostMapping("/estacionamento/registro")
    public ResponseEntity<Vehicle> createVeiculo(@Validated @RequestBody Vehicle veiculo) {
        Vehicle savedVeiculo = repository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVeiculo);
    }

    @PostMapping("/veiculos")
    public ResponseEntity<Vehicle> createVeiculo(@Validated @RequestBody VehicleDTO veiculoDTO) {
        // Verifica se a vaga está ocupada antes de prosseguir
        ParkingSpace vagaEscolhida = parkingSpaceRepository.findById(veiculoDTO.getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada."));

        if (vagaEscolhida.()) {
            throw new RuntimeException("A vaga escolhida já está ocupada.");
        }

        Vehicle veiculo = new Vehicle();
        veiculo.setOwnerName(veiculoDTO.getOwnerName());
        veiculo.setLicensePlate(veiculoDTO.getLicensePlate());
        veiculo.setPreferential(veiculoDTO.getPreferential());
        veiculo.setVehicleType(veiculoDTO.getVehicleType());
        veiculo.setParkingSpace(vagaEscolhida);

        // Marca a vaga como ocupada
        vagaEscolhida.setOccupied(true);
        parkingSpaceRepository.save(vagaEscolhida);

        Vehicle savedVeiculo = repository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVeiculo);
    }

}
