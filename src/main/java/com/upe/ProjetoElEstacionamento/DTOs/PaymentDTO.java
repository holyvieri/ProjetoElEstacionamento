package com.upe.ProjetoElEstacionamento.DTOs;

import java.time.LocalDateTime;
import java.util.Map;

public class PaymentDTO {
    private Double payment;
    private Map<String, LocalDateTime> timestamps;

    public PaymentDTO(Double payment, Map<String, LocalDateTime> timestamps) {
        this.payment = payment;
        this.timestamps = timestamps;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Map<String, LocalDateTime> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Map<String, LocalDateTime> timestamps) {
        this.timestamps = timestamps;
    }
}
