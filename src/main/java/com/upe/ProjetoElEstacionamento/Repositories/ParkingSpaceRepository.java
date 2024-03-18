package com.upe.ProjetoElEstacionamento.Repositories;


import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

}

