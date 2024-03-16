package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Motorcycle")
public class Motorcycle extends Vehicle{
    public Motorcycle(String ownerName, String licensePlate, Boolean preferential) {
        super(ownerName, licensePlate, preferential, parkingSpace);
        setRates(6.5,2.0);
    }

}
