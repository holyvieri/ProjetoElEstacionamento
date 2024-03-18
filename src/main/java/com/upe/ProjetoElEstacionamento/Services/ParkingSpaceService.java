package com.upe.ProjetoElEstacionamento.Services;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import com.upe.ProjetoElEstacionamento.exceptions.IncompatibleTypesException;
import com.upe.ProjetoElEstacionamento.exceptions.NotFoundVacancyException;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;

import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;
    private final VehicleRepository vehicleRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, VehicleRepository vehicleRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    //achar objeto parkingSpace por id
    public ParkingSpace findById(Long spaceId) {
        return parkingSpaceRepository.findById(spaceId)
                .orElse(null);
    }

    public Double getTimeGoneBy(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new NotFoundVacancyException("Não há como contabilizar o tempo, pois o "));
        return (double) Duration.between(space.getEnterTime(), space.getExitTime()).getSeconds();
    }

    public Map<String, Double> payment(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new NotFoundVacancyException("Não há como fazer o pagamento, pois o "));
        Map<String, Double> map = new HashMap<>();

        if (space.getSpaceType().equals(VehicleTypes.MOTORCYCLE)) {
            space.setBaseRate(6.50);
            space.setHourlyRate(2.00);
        } else if (space.getSpaceType().equals(VehicleTypes.BIKE)) {
            space.setBaseRate(1.00);
            space.setHourlyRate(0.25);
        } else if (space.getSpaceType().equals(VehicleTypes.CAR)) {
            space.setBaseRate(11.50);
            space.setHourlyRate(1.00);
        } else if (space.getSpaceType().equals(VehicleTypes.BUS)) {
            space.setBaseRate(4.25);
            space.setHourlyRate(0.50);
        } else {
            throw new IncompatibleTypesException("Não há como calcular o pagamento.");
        }
        double time = getTimeGoneBy(spaceId) / 60;

        if (!space.isSpacePreferential()) {
            if (time > 1.00) {
                double payment = space.getBaseRate() + (space.getHourlyRate() * (time - 1.00));

                map.put("payment", Double.parseDouble(String.format("%.2f", payment)));

            } else {
                map.put("payment", space.getBaseRate());
            }
        } else {
            map.put("payment", 0.0);

        }
        map.put("baseRate", space.getBaseRate());
        map.put("hourlyRate", space.getHourlyRate());
        return map;
    }

    public Map<String, LocalDateTime> getEnterAndExitTime(Long spaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(spaceId)
                .orElseThrow(() -> new NotFoundVacancyException());

        Map<String, LocalDateTime> timestamps = new HashMap<>();
        timestamps.put("enterTime", space.getEnterTime());
        timestamps.put("exitTime", space.getExitTime());
        return timestamps;
    }
}
