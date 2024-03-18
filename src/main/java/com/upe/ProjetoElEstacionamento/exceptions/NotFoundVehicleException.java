package com.upe.ProjetoElEstacionamento.exceptions;

public class NotFoundVehicleException extends RuntimeException{
    public NotFoundVehicleException(){
        super("ID do veículo especificado não foi encontrado.");
    }
    public NotFoundVehicleException(String message){
        super(message + "ID do veículo especificado não foi encontrado.");
    }
}
