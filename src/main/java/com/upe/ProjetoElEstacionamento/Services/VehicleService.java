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
    private CarRepository carRepository; // Repositório para Carros
    @Autowired
    private BikeRepository bikeRepository; // Repositório para Bicicletas
    @Autowired
    private BusRepository busRepository; // Repositório para Ônibus
    @Autowired
    private MotorcycleRepository motorcycleRepository; // Repositório para Motocicletas

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        // Lógica para criar um novo veículo e associar à vaga correta
        ParkingSpace parkingSpace = parkingSpaceRepository.findAvailableSpaceByType(vehicleDTO.getVehicleType());
        if (parkingSpace == null) {
            throw new RuntimeException("Nenhuma vaga disponível do tipo especificado.");
        }

        if (parkingSpace.isPreferential()) {
            throw new RuntimeException("A vaga escolhida já está ocupada.");
        }

        Vehicle newVehicle;
        switch (vehicleDTO.getVehicleType()) {
            case "Car":
                newVehicle = new Car(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                carRepository.save((Car) newVehicle);
                break;
            case "Bike":
                newVehicle = new Bike(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                bikeRepository.save((Bike) newVehicle);
                break;
            case "Bus":
                newVehicle = new Bus(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                busRepository.save((Bus) newVehicle);
                break;
            case "Motorcycle":
                newVehicle = new Motorcycle(vehicleDTO.getOwnerName(), vehicleDTO.getLicensePlate(), vehicleDTO.getPreferential());
                motorcycleRepository.save((Motorcycle) newVehicle);
                break;
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }

        newVehicle.setParkingSpace(parkingSpace);
        parkingSpace.setOccupied(true);
        parkingSpaceRepository.save(parkingSpace);

        return newVehicle;
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
