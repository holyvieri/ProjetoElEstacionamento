package com.upe.ProjetoElEstacionamento.exceptions;

public class VacancyOccupiedException extends RuntimeException{
    public VacancyOccupiedException(){
        super("A vaga escolhida já está ocupada.");
    }
}
