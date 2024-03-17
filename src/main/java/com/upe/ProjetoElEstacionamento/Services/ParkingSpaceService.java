package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;
import org.springframework.beans.factory.annotation.Autowired;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
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

    /*public Double payment(Long spaceId){
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Não há como fazer o pagamento, pois a vaga não foi encontrada com o ID especificado."));
        if (!space.isSpacePreferential()) {
            if (space.getSpaceType().equals(VehicleTypes.MOTORCYCLE)) {
                space.setBaseRate(6.5);
                space.setBaseRate(2.0);
            } else if (space.getSpaceType().equals(VehicleTypes.BIKE)) {
                space.setBaseRate(1.0);
                space.setHourlyRate(0.25);
            } else if (space.getSpaceType().equals(VehicleTypes.CAR)) {
                space.setBaseRate(11.5);
                space.setHourlyRate(1.0);
            } else if (space.getSpaceType().equals(VehicleTypes.BUS)) {
                space.setBaseRate(5.0);
                space.setHourlyRate(0.5);
            }
            long time = space.getTimeGoneBy()/60;
            if(time > 1){
                return (space.getBaseRate()+(space.getHourlyRate()*(time-1)));
            }else{
                return space.getBaseRate();
            }
        }else{
            return 0.0;
        }
    }*/

}
