package com.upe.ProjetoElEstacionamento.model;

public class Bus extends Vehicle{
    public Bus(String name, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        super(name, licensePlate, preferential, String.valueOf(vehicleType));
    }

    @Override
    public void entry() {

    }

    @Override
    public void payment() {

    }

}
