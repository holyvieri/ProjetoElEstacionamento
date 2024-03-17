package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;


import javax.swing.text.DateFormatter;
import javax.xml.crypto.Data;

@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "occupied")
    private boolean occupied;

    @Column(name = "preferential")
    private boolean spacePreferential;

    @Column(name = "base_rate")
    private Double baseRate;

    @Column(name = "hourly_rate")
    private Double hourly_rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "space_type")
    private VehicleTypes spaceType;

    @Column(name = "date")
    private String date;


    public ParkingSpace(){

    }
    public ParkingSpace(Long id, boolean occupied, boolean spacePreferential,
                        Double baseRate, Double hourly_rate, VehicleTypes spaceType, String date) {
        this.id = id;
        this.occupied = occupied;
        this.spacePreferential = spacePreferential;
        this.baseRate = baseRate;
        this.hourly_rate = hourly_rate;
        this.spaceType = spaceType;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isSpacePreferential() {
        return spacePreferential;
    }

    public void setSpacePreferential(boolean spacePreferential) {
        this.spacePreferential = spacePreferential;
    }

    public Double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(Double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public VehicleTypes getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(VehicleTypes spaceType) {
        this.spaceType = spaceType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
