package com.upe.ProjetoElEstacionamento;

import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import com.upe.ProjetoElEstacionamento.model.VehicleTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProjetoElEstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoElEstacionamentoApplication.class, args);
	}
}
