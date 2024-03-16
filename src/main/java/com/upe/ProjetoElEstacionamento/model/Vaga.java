package com.upe.ProjetoElEstacionamento.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vagas")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "ocupada")
    protected boolean ocupada;
    protected
}
