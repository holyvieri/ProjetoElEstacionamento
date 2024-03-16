package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.Repositories.VagaRepository;
import com.upe.ProjetoElEstacionamento.Repositories.VeiculoRepository;
import com.upe.ProjetoElEstacionamento.model.Vehicle;
import com.upe.ProjetoElEstacionamento.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
    private VagaRepository vagaRepository;
    private VeiculoRepository veiculoRepository;

    @Autowired
    public EstacionamentoController(VagaRepository vagaRepository, VeiculoRepository veiculoRepository) {
        this.vagaRepository = vagaRepository;
        this.veiculoRepository = veiculoRepository;
    }



}
