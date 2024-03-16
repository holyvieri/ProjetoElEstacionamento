package com.upe.ProjetoElEstacionamento.model;

import jakarta.persistence.*;

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

    @Column(name = "space_type")
    private String spaceType;

    @Column(name = "date")
    private String date;


}
