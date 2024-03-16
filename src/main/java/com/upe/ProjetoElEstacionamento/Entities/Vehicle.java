package com.upe.ProjetoElEstacionamento.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tax")
    protected Double tax;
    @Column(name = "nome_proprietario")
    protected String name;
    @Column(name = "placa")
    protected String licensePlate;
    @Column(name = "preferencial")
    protected Boolean preferential;
    @Column(name = "tipo_veiculo")
    protected VehicleType vehicleType;
    @OneToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    public Vehicle(String name, String licensePlate, Boolean preferential, VehicleType vehicleType) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.preferential = preferential;
        this.vehicleType = vehicleType;
    }

    public abstract void entry();
    public abstract void payment();
}
