package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.exceptions.IncompatibleTypesException;
import com.upe.ProjetoElEstacionamento.exceptions.NotFoundVacancyException;
import com.upe.ProjetoElEstacionamento.exceptions.NotFoundVehicleException;
import com.upe.ProjetoElEstacionamento.exceptions.VacancyOccupiedException;
import com.upe.ProjetoElEstacionamento.Repositories.*;
import com.upe.ProjetoElEstacionamento.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, ParkingSpaceRepository parkingSpaceRepository) {
        this.vehicleRepository = vehicleRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    // Lógica para criar um novo veículo e associar à vaga correta
    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        // Achar id da vaga e checar se ela existe

        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicleDTO.getParkingSpace().getSpaceId())
                .orElseThrow(NotFoundVacancyException::new);
        //checar se vaga tá ocupada
        if (parkingSpace.isOccupied()) {
            // Checar se vaga tá ocupada
            throw new VacancyOccupiedException();
        }
        else if (parkingSpace.getSpaceType() != vehicleDTO.getVehicleType()) {
            // Checar se a vaga tem o mesmo tipo do veículo
            throw new IncompatibleTypesException();
        }
        else {
            // Cria um novo veículo com base nos dados do DTO
            Vehicle newVehicle = new Vehicle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(),
                    vehicleDTO.getPreferential(), vehicleDTO.getVehicleType(), vehicleDTO.getParkingSpace());
            newVehicle.setParkingSpace(parkingSpace);
            parkingSpace.setOccupied(true);
            parkingSpace.setEnterTime(LocalDateTime.now()); //tempo entrada
            parkingSpaceRepository.save(parkingSpace);

            return vehicleRepository.save(newVehicle);
        }
    }
    public void removeVehicleFromSpace(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado."));
        ParkingSpace parkingSpace = vehicle.getParkingSpace();
        if (parkingSpace != null) {
            parkingSpace.setOccupied(false);
            parkingSpace.setExitTime(LocalDateTime.now()); //tempo saida
            parkingSpaceRepository.save(parkingSpace);
        }
        vehicleRepository.delete(vehicle);
    }

    public Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElse(null);
    }


}
