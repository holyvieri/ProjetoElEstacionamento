package com.upe.ProjetoElEstacionamento.exceptions;

public class NotFoundVacancyException extends RuntimeException{
    public NotFoundVacancyException (){
        super("Vaga não encontrada");
    }
}
