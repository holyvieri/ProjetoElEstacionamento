package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Repositories.*;
import com.upe.ProjetoElEstacionamento.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        // Lógica para criar um novo veículo e associar à vaga correta
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicleDTO.getParkingSpace().getId())
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID especificado."));

        if (parkingSpace.isOccupied()) {
            throw new RuntimeException("A vaga escolhida já está ocupada.");
        }

        // Cria um novo veículo com base nos dados do DTO
        Vehicle newVehicle = new Vehicle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(),
                vehicleDTO.getPreferential(), vehicleDTO.getVehicleType(), vehicleDTO.getParkingSpace());
        newVehicle.setParkingSpace(parkingSpace);
        parkingSpace.setOccupied(true);
        parkingSpaceRepository.save(parkingSpace);

        return vehicleRepository.save(newVehicle);

    }
    public void removeVehicleFromSpace(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado."));

        ParkingSpace parkingSpace = vehicle.getParkingSpace();
        if (parkingSpace != null) {
            parkingSpace.setOccupied(false);
            parkingSpaceRepository.save(parkingSpace);
        }

        vehicleRepository.delete(vehicle);
    }

    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElse(null);
    }
}
