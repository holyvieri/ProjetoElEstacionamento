package com.upe.ProjetoElEstacionamento.repository;

import com.upe.ProjetoElEstacionamento.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Vehicle, Integer> {


}
