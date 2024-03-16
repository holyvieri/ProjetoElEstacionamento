package com.upe.ProjetoElEstacionamento.model;

public class Bike extends Vehicle{
//    baseRate = 1.0;
//    hourlyRate = 0.25;
    public Bike(String ownerName, String licensePlate, Boolean preferential){
        super(ownerName, licensePlate, preferential);
    }

    @Override
    public void setHourlyRate(Double hourlyRate) {
        super.setHourlyRate(0.25);
    }
}
