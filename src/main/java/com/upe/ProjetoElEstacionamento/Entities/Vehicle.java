package com.upe.ProjetoElEstacionamento.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public abstract class Vehicle {
    protected Double tax;
    protected String name;
    protected String licensePlate;
    protected Boolean preferential;
    protected VehicleType vehicleType;

    public Vehicle(String name, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.preferential = preferential;
        this.vehicleType = vehicleType;
    }

    public abstract void entry();
    public abstract void payment();
}
