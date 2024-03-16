package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.DTOs.ParkingSpaceDTO;
import com.upe.ProjetoElEstacionamento.DTOs.VehicleDTO;
import com.upe.ProjetoElEstacionamento.Repositories.*;
import com.upe.ProjetoElEstacionamento.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        // Lógica para criar um novo veículo e associar à vaga correta
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(vehicleDTO.getParkingSpaceId())
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID especificado."));

        if (parkingSpace.isOccupied()) {
            throw new RuntimeException("A vaga escolhida já está ocupada.");
        }

        // Cria um novo veículo com base nos dados do DTO
        Vehicle newVehicle;
        switch () {
            case "Car":
                newVehicle = new Car(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                break;
            case "Bike":
                newVehicle = new Bike(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential(), vehicleDTO.getParkingSpaceId());
                break;
            case "Bus":
                newVehicle = new Bus(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                break;
            case "Motorcycle":
                newVehicle = new Motorcycle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                break;
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }

        // Associa o veículo à vaga
        newVehicle.setParkingSpace(parkingSpace);
        parkingSpace.setOccupied(true);
        parkingSpaceRepository.save(parkingSpace);

        // Salva o novo veículo no repositório
        return vehicleRepository.save(newVehicle);
    }

    public void removeVehicleFromSpace(Integer vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle == null) {
            throw new RuntimeException("Veículo não encontrado.");
        }

        ParkingSpace parkingSpace = vehicle.getParkingSpace();
        if (parkingSpace != null) {
            parkingSpace.setOccupied(false);
            parkingSpaceRepository.save(parkingSpace);
        }

        if (vehicle instanceof Car) {
            carRepository.delete((Car) vehicle);
        } else if (vehicle instanceof Bike) {
            bikeRepository.delete((Bike) vehicle);
        } else if (vehicle instanceof Bus) {
            busRepository.delete((Bus) vehicle);
        } else if (vehicle instanceof Motorcycle) {
            motorcycleRepository.delete((Motorcycle) vehicle);
        }
    }

    public Vehicle findVehicleById(Integer vehicleId) {
        Optional<Car> carOptional = carRepository.findById(vehicleId);
        if (carOptional.isPresent()) {
            return carOptional.get();
        }

        Optional<Bike> bikeOptional = bikeRepository.findById(vehicleId);
        if (bikeOptional.isPresent()) {
            return bikeOptional.get();
        }

        Optional<Bus> busOptional = busRepository.findById(vehicleId);
        if (busOptional.isPresent()) {
            return busOptional.get();
        }

        Optional<Motorcycle> motorcycleOptional = motorcycleRepository.findById(vehicleId);
        return motorcycleOptional.orElse(null);

    }
}
