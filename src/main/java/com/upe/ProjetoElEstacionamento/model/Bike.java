package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle {
    public Bike(String ownerName, String licensePlate, Boolean preferential, ParkingSpace parkingSpace) {
        super(ownerName, licensePlate, preferential, parkingSpace);
        setRates(1.0, 0.25);
}
