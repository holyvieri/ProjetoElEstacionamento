package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {
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

    @Column(name = "entrada")
    private LocalDateTime enterTime;

    @Column(name = "saida")
    private LocalDateTime exitTime;

    @Column(name = "tempo_em_andamento")
    private long timeGoneBy; // em segundos

    public ParkingSpace(){}

    public ParkingSpace(Long spaceId, boolean occupied, boolean spacePreferential,
                        Double baseRate, Double hourlyRate, VehicleTypes spaceType) {
        this.spaceId = spaceId;
        this.occupied = occupied;
        this.spacePreferential = spacePreferential;
        this.baseRate = baseRate;
        this.hourlyRate = hourlyRate;
        this.spaceType = spaceType;

    }

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

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalDateTime enterTime) {
        this.enterTime = enterTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public long getTimeGoneBy() {
        if (enterTime == null || exitTime == null) {
            throw new RuntimeException("Entrada ou saída não registrada.");
        }
        Duration duration = Duration.between(enterTime, exitTime);
        timeGoneBy = duration.getSeconds();
        return timeGoneBy; // Retorna o tempo decorrido em segundos
    }


    public void setTimeGoneBy(long timeGoneBy) {
        this.timeGoneBy = timeGoneBy;
    }

}
