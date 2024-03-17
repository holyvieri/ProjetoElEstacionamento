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

    public Double payment(Long spaceId){
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID especificado."));
        if (!space.isSpacePreferential()) {
            if (space.getSpaceType().equals("MOTORCYCLE")) {
                space.setBaseRate(6.5);
                space.setBaseRate(2.0);
            } else if (space.getSpaceType().equals("BIKE")) {
                space.setBaseRate(1.0);
                space.setHourly_rate(0.25);
            } else if (space.getSpaceType().equals("CAR")) {
                space.setBaseRate(11.5);
                space.setHourly_rate(1.0);
            } else if (space.getSpaceType().equals("BUS")) {
                space.setBaseRate(5.0);
                space.setHourly_rate(0.5);
            }
            long time = space.getTimeGoneBy()/60;
            if(time > 1){
                return (space.getBaseRate()+(space.getHourly_rate()*(time-1)));
            }else{
                return space.getBaseRate();
            }
        }else{
            return 0.0;
        }
    }

    public void startTiming(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID especificado."));

        space.setEnterTime(LocalDateTime.now());
        parkingSpaceRepository.save(space);

    }

    public void endTiming(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        space.setExitTime(LocalDateTime.now());
        parkingSpaceRepository.save(space);
    }




}
