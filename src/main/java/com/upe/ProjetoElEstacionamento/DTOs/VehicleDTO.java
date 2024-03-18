package com.upe.ProjetoElEstacionamento.DTOs;

import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;

public class VehicleDTO {
    private String ownerName;
    private String licensePlate;
    private Boolean preferential;
    private VehicleTypes vehicleType;
    private Long parkingSpace;

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

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Long parkingSpace) {
        this.parkingSpace = parkingSpace;
    }


}
