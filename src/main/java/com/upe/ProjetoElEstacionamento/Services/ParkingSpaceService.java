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

    public ParkingSpace startTiming(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID especificado."));

        space.setEnterTime(LocalDateTime.now());
        parkingSpaceRepository.save(space);

        return space;
    }

    public ParkingSpace endTiming(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        space.setExitTime(LocalDateTime.now());
        parkingSpaceRepository.save(space);

        return space;
    }




}
