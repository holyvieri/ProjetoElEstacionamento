package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingSpaceService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    //achar objeto parkingSpace por id
    public ParkingSpace findById(Long spaceId){
        return parkingSpaceRepository.findById(spaceId)
                .orElse(null);
    }

    public ParkingSpace startTiming() {
        ParkingSpace space = new ParkingSpace();
        space.setEnterTime(LocalDateTime.now());
        space.setOccupied(true);
        parkingSpaceRepository.save(space);

        // Atualiza a vaga de estacionamento para ocupado
        ParkingSpace parkingSpace = parkingSpaceRepository.findFirstUnoccupied();
        if (parkingSpace != null) {
            parkingSpace.setOcupado(true);
            parkingSpaceRepository.save(parkingSpace);
        }

        return estacionamento;
    }

    public Estacionamento finalizarEstacionamento(Long id) {
        Estacionamento estacionamento = estacionamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        estacionamento.setSaida(LocalDateTime.now());
        estacionamento.setEmAndamento(false);
        estacionamentoRepository.save(estacionamento);

        // Atualiza a vaga de estacionamento para livre
        ParkingSpace parkingSpace = parkingSpaceRepository.findFirstByOcupadoTrue();
        if (parkingSpace != null) {
            parkingSpace.setOcupado(false);
            parkingSpaceRepository.save(parkingSpace);
        }

        return estacionamento;
    }



}
