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
    private String date = date.substring();


    public double payment(){
        if (preferential == True){
            return 0.0;
        }else{
            double secs = Double.parseDouble(date);
            return baseRate+hourly_rate*secs;
        }
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setPreferential(boolean preferential) {
        this.preferential = preferential;
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

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
