package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{
    private final Double tax = 11.5;
    private final Double additionalTaxPerHour = 1.0;
    public Car(String ownerName, String licensePlate, Boolean preferential) {
        super(ownerName, licensePlate, preferential);
    }

}
