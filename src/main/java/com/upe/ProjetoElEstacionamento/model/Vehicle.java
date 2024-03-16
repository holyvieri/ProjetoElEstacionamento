package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_rate")
    protected Double baseRate;

    @Column(name = "hourly_rate")
    protected Double hourlyRate;

    @Column(name = "owner_name")
    protected String ownerName;

    @Column(name = "license_plate")
    protected String licensePlate;

    @Column(name = "preferential")
    protected Boolean preferential;

    @Column(name = "vehicle_type")
    protected String vehicleType;

    @OneToOne
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    public Vehicle(String ownerName, String licensePlate, Boolean preferential, String vehicleType) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.preferential = preferential;
        this.vehicleType = vehicleType;
    }

    public Vehicle() {

    }

    public abstract void entry();
    public abstract void payment();

    // Getters and Setters
}