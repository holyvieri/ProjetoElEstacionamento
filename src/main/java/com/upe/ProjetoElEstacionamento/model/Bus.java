package com.upe.ProjetoElEstacionamento.model;

public class Bus extends Vehicle{
    private final Double tax = 5.0;
    private final Double additionalTaxPerHour = 0.5;
    public Bus(String ownerName, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        super(ownerName, licensePlate, preferential, String.valueOf(vehicleType));
    }

    @Override
    public void entry() {

    }

    public Double getTax() {
        return tax;
    }

    public Double getAdditionalTaxPerHour() {
        return additionalTaxPerHour;
    }
}
