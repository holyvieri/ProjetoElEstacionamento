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
    private boolean preferential;

    @Column(name = "base_rate")
    private Double baseRate;

    @Column(name = "hourly_rate")
    private Double hourly_rate;

    @Column(name = "space_type")
    private String spaceType;

    @Column(name = "date")
    private String date;

    public void setId(Long id) {
        this.id = id;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setPreferential(boolean preferential) {
        this.preferential = preferential;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isPreferential() {
        return preferential;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public String getDate() {
        return date;
    }
}
