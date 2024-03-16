package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type", discriminatorType = DiscriminatorType.STRING)
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


    @OneToOne
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    public Vehicle(String ownerName, String licensePlate, Boolean preferential, ParkingSpace parkingSpace) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.preferential = preferential;
        this.parkingSpace = parkingSpace;
    }

    public Vehicle() {}

    public void setRates(double base_rate, double hourly_rate){
        parkingSpace.setBaseRate(base_rate);
        parkingSpace.setHourly_rate(hourly_rate);
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
        return preferential;
    }

    public void setPreferential(Boolean preferential) {
        this.preferential = preferential;
    }


    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}