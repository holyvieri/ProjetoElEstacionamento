package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle{
//    baseRate = 1.0;
//    hourlyRate = 0.25;
    public Bike(String ownerName, String licensePlate, Boolean preferential){
        super(ownerName, licensePlate, preferential, String.valueOf(vehicleType));
    }
    @Override
    public void setHourlyRate(Double hourlyRate) {
        super.setHourlyRate(hourlyRate);
    }
}
