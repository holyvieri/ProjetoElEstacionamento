package com.upe.ProjetoElEstacionamento.Repositories;

import com.upe.ProjetoElEstacionamento.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
}
