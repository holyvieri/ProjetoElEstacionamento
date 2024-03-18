package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Service
public class ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;
    private final VehicleRepository vehicleRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    //achar objeto parkingSpace por id
    public ParkingSpace findById(Long spaceId){
        return parkingSpaceRepository.findById(spaceId)
                .orElse(null);
    }

    public Double getTimeGoneBy(Long spaceId){
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Não há como contabilizar o tempo, pois a vaga não foi encontrada com o ID especificado."));
        return (double) Duration.between(space.getEnterTime(), space.getExitTime()).getSeconds();
    }

    public Double payment(Long spaceId){
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Não há como fazer o pagamento, pois a vaga não foi encontrada com o ID especificado."));
        if (space.isSpacePreferential() == false) {
            if (space.getSpaceType().equals(VehicleTypes.MOTORCYCLE)) {
                space.setBaseRate(6.50);
                space.setBaseRate(2.00);
            } else if (space.getSpaceType().equals(VehicleTypes.BIKE)) {
                space.setBaseRate(1.00);
                space.setHourlyRate(0.25);
            } else if (space.getSpaceType().equals(VehicleTypes.CAR)) {
                space.setBaseRate(11.50);
                space.setHourlyRate(1.00);
            } else if (space.getSpaceType().equals(VehicleTypes.BUS)) {
                space.setBaseRate(4.25);
                space.setHourlyRate(0.50);
            }else {
                throw new RuntimeException("Não há como calcular o pagamento, pois o tipo de vaga e o tipo de veículo não são compatíveis.");
            }
            double time = getTimeGoneBy(spaceId)/60;
            if(time > 1.00){
                double payment = space.getBaseRate()+(space.getHourlyRate()*(time-1.00));
                return Double.parseDouble(String.format("%.2f", payment));
            }else{
                return space.getBaseRate();
            }
        }else{
            return 0.00;
        }
    }
}
