package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bus")
public class Bus extends Vehicle{
    public Bus(String ownerName, String licensePlate, Boolean preferential) {
        super(ownerName, licensePlate, preferential, parkingSpace);
        setRates(5.0, 0.5);
    }

}
