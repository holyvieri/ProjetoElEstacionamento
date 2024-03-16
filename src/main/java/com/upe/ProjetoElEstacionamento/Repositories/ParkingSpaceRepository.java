package com.upe.ProjetoElEstacionamento.Repositories;


import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<ParkingSpace, Long> {
    @Override
    List<ParkingSpace> findAll();
}
