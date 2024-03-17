package com.upe.ProjetoElEstacionamento.DTOs;

import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;

public class VehicleDTO {
    private String ownerName;
    private String licensePlate;
    private Boolean preferential;
    private String vehicleType;
    private ParkingSpace parkingSpace;

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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
    public VehicleTypes getVehicleTypeEnum() {
        // Converte a string para enum
        return VehicleTypes.valueOf(vehicleType.toUpperCase()); // Supondo que a string recebida seja "CAR", "BIKE", "BUS" ou "MOTORCYCLE"
    }

}
