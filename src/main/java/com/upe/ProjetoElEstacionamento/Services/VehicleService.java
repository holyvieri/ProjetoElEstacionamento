package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.exceptions.IncompatibleTypesException;
import com.upe.ProjetoElEstacionamento.exceptions.NotFoundVacancyException;
import com.upe.ProjetoElEstacionamento.exceptions.VacancyOccupiedException;
import com.upe.ProjetoElEstacionamento.Repositories.*;
import com.upe.ProjetoElEstacionamento.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, ParkingSpaceRepository parkingSpaceRepository) {
        this.vehicleRepository = vehicleRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    // Lógica para criar um novo veículo e associar à vaga correta
    public Long createVehicle(VehicleDTO vehicleDTO) {
        // Achar id da vaga e checar se ela existe
        //clear time
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicleDTO.getParkingSpace())
                .orElseThrow(NotFoundVacancyException::new);
        //checar se vaga tá ocupada
        if (parkingSpace.isOccupied()) {
            // Checar se vaga tá ocupada
            throw new VacancyOccupiedException();
        } else if (parkingSpace.getSpaceType() != vehicleDTO.getVehicleType()) {
            // Checar se a vaga tem o mesmo tipo do veículo e agr checa se possui o critério preferencial
            if (parkingSpace.isSpacePreferential() != vehicleDTO.getPreferential()){
                throw new IncompatibleTypesException();
            }
            throw new IncompatibleTypesException();
        } else {
            // Cria um novo veículo com base nos dados do DTO
            Vehicle newVehicle = new Vehicle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(),
                    vehicleDTO.getPreferential(), vehicleDTO.getVehicleType(), vehicleDTO.getParkingSpace());
            newVehicle.setParkingSpace(parkingSpace.getSpaceId());

            Vehicle savedVehicle = vehicleRepository.save(newVehicle);
            parkingSpace.setVehicleId(savedVehicle.getId());
            parkingSpace.setOccupied(true);
            parkingSpace.setEnterTime(LocalDateTime.now()); //tempo entrada
            parkingSpaceRepository.save(parkingSpace);

            return savedVehicle.getId();
        }
    }
    public void removeVehicleFromSpace(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Não há como remover o veículo da vaga, pois o ID do veículo especificado não foi encontrado."));
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicle.getParkingSpace())
                .orElseThrow(NotFoundVacancyException::new);
        if (parkingSpace != null) {
            parkingSpace.setOccupied(false);
            parkingSpace.setVehicleId(null);
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
