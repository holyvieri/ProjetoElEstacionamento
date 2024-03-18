package com.upe.ProjetoElEstacionamento.exceptions;

public class NotFoundVacancyException extends RuntimeException{
    public NotFoundVacancyException (){
        super("ID da vaga especificada não foi encontrado.");
    }
    public NotFoundVacancyException (String message){
        super(message + "ID da vaga especificada não foi encontrado.");
    }
}
