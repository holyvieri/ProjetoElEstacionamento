package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;
import org.springframework.beans.factory.annotation.Autowired;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ParkingSpace payment(VehicleTypes spaceType){
        if (spaceType.equals(VehicleTypes.BIKE)){

        }else if (spaceType.equals(VehicleTypes.BUS)) {

        } else if (spaceType.equals(VehicleTypes.CAR)) {

        } else if (spaceType.equals(VehicleTypes.MOTORCYCLE)) {
            
        }
    }





}
