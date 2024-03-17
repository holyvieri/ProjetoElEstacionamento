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

    //ok
    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        // Lógica para criar um novo veículo e associar à vaga correta
        // achar id da vaga e checar se ela existe
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicleDTO.getParkingSpace().getSpaceId())
                .orElseThrow(() -> new RuntimeException("Não há como criar a associação entre veículo e vaga, pois a vaga não foi encontrada com o ID especificado."));

        //checar se vaga tá ocupada
        if (parkingSpace.isOccupied()) {
            throw new RuntimeException("Não há como estacionar, pois a vaga escolhida já está ocupada.");
        } else if (parkingSpace.getSpaceType() != vehicleDTO.getVehicleType()) {
            throw new RuntimeException("Não há como estacionar, pois o veículo não é compatível com a vaga escolhida.");
        } else {
            // Cria um novo veículo com base nos dados do DTO-
            Vehicle newVehicle = new Vehicle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(),
                    vehicleDTO.getPreferential(), vehicleDTO.getVehicleType(), vehicleDTO.getParkingSpace());
            newVehicle.setParkingSpace(parkingSpace);
            parkingSpace.setOccupied(true);
            parkingSpaceRepository.save(parkingSpace);


            return vehicleRepository.save(newVehicle);
        }
    }
    public void removeVehicleFromSpace(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Não há como sair do estacionamento, pois o veículo não foi encontrado com o ID especificado."));

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
