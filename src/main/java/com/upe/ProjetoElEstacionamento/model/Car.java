package com.upe.ProjetoElEstacionamento.model;

public class Car extends Vehicle{
    private final Double tax = 11.5;
    private final Double additionalTaxPerHour = 1.0;
    public Car(String name, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        super(name, licensePlate, preferential, vehicleType);
    }

    @Override
    public void entry() {

    }
    @Override
    public void payment() {

    }
}
