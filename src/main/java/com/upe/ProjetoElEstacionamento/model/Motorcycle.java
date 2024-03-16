package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Motorcycle")
public class Motorcycle extends Vehicle{
    private final Double tax = 6.5;
    private final Double additionalTaxPerHour = 2.0;
    public Motorcycle(String ownerName, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        super(ownerName, licensePlate, preferential, String.valueOf(vehicleType));
    }

    public Double getTax() {
        return tax;
    }

    public Double getAdditionalTaxPerHour() {
        return additionalTaxPerHour;
    }
}
