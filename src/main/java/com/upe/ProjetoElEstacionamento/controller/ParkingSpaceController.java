package com.upe.ProjetoElEstacionamento.controller;

import com.upe.ProjetoElEstacionamento.DTOs.PaymentDTO;
import com.upe.ProjetoElEstacionamento.Repositories.ParkingSpaceRepository;
import com.upe.ProjetoElEstacionamento.Services.ParkingSpaceService;
import com.upe.ProjetoElEstacionamento.model.ParkingSpace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/parking_space")
public class ParkingSpaceController {
    private final ParkingSpaceRepository spaceRepository;
    private final ParkingSpaceService spaceService;

    public ParkingSpaceController(ParkingSpaceRepository spaceRepository, ParkingSpaceService spaceService) {
        this.spaceRepository = spaceRepository;
        this.spaceService = spaceService;
    }

    @CrossOrigin
    @GetMapping
    public List<ParkingSpace> getAll() {
        List<ParkingSpace> orderedParkingSpaces = spaceRepository.findAll().stream().sorted(Comparator.comparing(ParkingSpace::getSpaceId)).toList();
        return orderedParkingSpaces;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getSpaceById(@PathVariable Long id) {
        ParkingSpace space = spaceRepository.findById(id)
                .orElse(null);
        if (space != null) {
            return ResponseEntity.ok(space);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id) {
        Map<String, Double> map = spaceService.payment(id);
        Map<String, LocalDateTime> timestamps = spaceService.getEnterAndExitTime(id);
        if (map != null && timestamps != null) {
            PaymentDTO paymentDTO = new PaymentDTO(map, timestamps);
            return ResponseEntity.ok(paymentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
