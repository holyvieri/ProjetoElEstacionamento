package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
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

    public Vehicle() {

    }

    public abstract void entry();
    public abstract void payment();
}
