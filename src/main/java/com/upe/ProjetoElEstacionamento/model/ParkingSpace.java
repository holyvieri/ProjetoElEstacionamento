package com.upe.ProjetoElEstacionamento.model;

import com.upe.ProjetoElEstacionamento.Repositories.VehicleRepository;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long spaceId;

    @Column(name = "occupied")
    private boolean occupied;

    @Column(name = "preferential")
    private boolean spacePreferential;

    @Column(name = "base_rate")
    private Double baseRate;



    @Column(name = "hourly_rate")
    private Double hourlyRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "space_type")
    private VehicleTypes spaceType;

    @Column(name = "enter_time")
    LocalDateTime enterTime;

    @Column(name = "exit_time")
    LocalDateTime exitTime;

    @Column(name = "vehicle_id")
    private Long vehicleId;


    public ParkingSpace(){}

    //Construtor
    public ParkingSpace(Long spaceId, boolean occupied, boolean spacePreferential, VehicleTypes spaceType) {
        this.spaceId = spaceId;
        this.occupied = occupied;
        this.spacePreferential = spacePreferential;
        this.spaceType = spaceType;

    }

    //Getters e Setters
    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
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

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourly_rate) {
        this.hourlyRate = hourly_rate;
    }

    public VehicleTypes getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(VehicleTypes spaceType) {
        this.spaceType = spaceType;
    }
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalDateTime enterTime) {
        this.enterTime = enterTime;
    }

}
