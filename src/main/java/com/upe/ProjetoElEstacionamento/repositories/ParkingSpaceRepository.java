package com.upe.ProjetoElEstacionamento.repositories;


import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    @Query("SELECT p FROM ParkingSpace p WHERE p.ocupado = false ORDER BY p.id ASC")
    ParkingSpace findFirstUnoccupied();
    @Query("SELECT ps FROM ParkingSpace ps WHERE ps.spaceType = :type AND ps.occupied = false")
    ParkingSpace findAvailableSpaceByType(@Param("type") String type);
}

