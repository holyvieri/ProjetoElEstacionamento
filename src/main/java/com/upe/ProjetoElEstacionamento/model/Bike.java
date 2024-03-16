package com.upe.ProjetoElEstacionamento.model;

public class Bike extends Vehicle{
//    baseRate = 1.0;
//    hourlyRate = 0.25;
    public Bike(String ownerName, String licensePlate, Boolean preferential, VehicleType vehicleType){
        super(ownerName, licensePlate, preferential, String.valueOf(vehicleType));
    }

    @Override
    public void entry() {

    }




    @Override
    public void setHourlyRate(Double hourlyRate) {
        super.setHourlyRate(hourlyRate);
    }
}
