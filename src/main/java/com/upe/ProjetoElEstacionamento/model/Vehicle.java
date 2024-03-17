package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
@Table(name = "vehicles")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

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

    @OneToOne
    @JoinColumn(name = "parking_space")
    private ParkingSpace parkingSpace;

    public Vehicle(String ownerName, String licensePlate, Boolean vehiclePreferential, VehicleTypes vehicleType,ParkingSpace parkingSpace) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.vehiclePreferential = vehiclePreferential;
        this.vehicleType = vehicleType;
        this.parkingSpace = parkingSpace;
    }

    public Vehicle() {}

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


    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}