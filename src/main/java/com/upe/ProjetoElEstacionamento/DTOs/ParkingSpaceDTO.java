package com.upe.ProjetoElEstacionamento.DTOs;

import com.upe.ProjetoElEstacionamento.model.VehicleTypes;

public class ParkingSpaceDTO {
    private Long spaceId;
    private boolean occupied;

    private boolean preferential;

    private VehicleTypes spaceType;

    private String date;

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

    public boolean isPreferential() {
        return preferential;
    }

    public void setPreferential(boolean preferential) {
        this.preferential = preferential;
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
