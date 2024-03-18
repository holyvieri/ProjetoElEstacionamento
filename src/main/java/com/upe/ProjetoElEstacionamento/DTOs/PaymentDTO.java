package com.upe.ProjetoElEstacionamento.DTOs;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.Map;

public class PaymentDTO {
    private Double payment;

    private Double baseRate;

    private Double hourlyRate;
    private Map<String, LocalDateTime> timestamps;

    public PaymentDTO(Map<String, Double> payment, Map<String, LocalDateTime> timestamps) {
        this.payment = payment.get("payment");
        this.baseRate = payment.get("baseRate");
        this.hourlyRate = payment.get("hourlyRate");
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

    public Double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
