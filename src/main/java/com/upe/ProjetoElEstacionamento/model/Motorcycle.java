package com.upe.ProjetoElEstacionamento.model;

public class Motorcycle extends Vehicle{
    private final Double tax = 6.5;
    private final Double additionalTaxPerHour = 2.0;
    public Motorcycle(String ownerName, String licensePlate, Boolean preferential) {
        super(ownerName, licensePlate, preferential);
    }


}
