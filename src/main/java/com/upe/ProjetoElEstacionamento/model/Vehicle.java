package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxa_base")
    protected Double baseRate;

    @Column(name = "taxa_hora")
    protected Double hourlyRate;

    @Column(name = "nome_proprietario")
    protected String ownerName;

    @Column(name = "placa")
    protected String licensePlate;

    @Column(name = "preferencial")
    protected Boolean preferential;

    @Column(name = "tipo_veiculo")
    protected String vehicleType;

    @ManyToOne
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    public Vehicle(String ownerName, String licensePlate, Boolean preferential, String vehicleType) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.preferential = preferential;
        this.vehicleType = vehicleType;
    }

    public abstract void entry();
    public abstract void payment();

    // Getters and Setters
}