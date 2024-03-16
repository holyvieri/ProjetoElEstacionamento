package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle{
    public Car(String ownerName, String licensePlate, Boolean preferential) {
        super(ownerName, licensePlate, preferential, parkingSpace);
        setRates(11.5,1.0);
    }

}
