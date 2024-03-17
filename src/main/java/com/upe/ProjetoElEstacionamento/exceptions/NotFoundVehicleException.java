package com.upe.ProjetoElEstacionamento.exceptions;

public class NotFoundVehicleException extends RuntimeException{
    public NotFoundVehicleException(){
        super("Veículo não encontrado.");
    }
}
