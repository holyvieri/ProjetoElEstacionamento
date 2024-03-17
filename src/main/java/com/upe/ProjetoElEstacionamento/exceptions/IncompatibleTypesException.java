package com.upe.ProjetoElEstacionamento.exceptions;

public class IncompatibleTypesException extends RuntimeException{
    public IncompatibleTypesException(){
        super("A tipo de vaga deve ser compatível com o veículo.");
    }
}
