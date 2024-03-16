package com.upe.ProjetoElEstacionamento.model;

public class Motorcycle extends Vehicle{
    private final Double tax = 6.5;
    private final Double additionalTaxPerHour = 2.0;
    public Motorcycle(String name, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        super(name, licensePlate, preferential, String.valueOf(vehicleType));
    }

    @Override
    public void entry() {

    }

    @Override
    public void payment() {

    }

}
