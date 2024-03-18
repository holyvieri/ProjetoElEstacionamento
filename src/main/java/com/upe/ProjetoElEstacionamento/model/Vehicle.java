package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name")
    protected String ownerName;

    @Column(name = "license_plate")
    protected String licensePlate;

    @Column(name = "preferential")

    protected Boolean vehiclePreferential;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type")
    private VehicleTypes vehicleType;


    @Column(name = "parking_space")
    private Long spaceId;

    public Vehicle() {}
    // Construtores
    public Vehicle(String ownerName, String licensePlate, Boolean vehiclePreferential, VehicleTypes vehicleType,Long spaceId) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.vehiclePreferential = vehiclePreferential;
        this.vehicleType = vehicleType;
        this.spaceId = spaceId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getPreferential() {
        return vehiclePreferential;
    }

    public void setPreferential(Boolean vehiclePreferential) {
        this.vehiclePreferential = vehiclePreferential;
    }

    public Long getParkingSpace() {
        return spaceId;
    }

    public void setParkingSpace(Long parkingSpace) {
        this.spaceId = parkingSpace;
    }
}