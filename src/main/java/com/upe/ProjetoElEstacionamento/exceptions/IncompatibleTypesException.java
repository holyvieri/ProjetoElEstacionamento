package com.upe.ProjetoElEstacionamento.exceptions;

public class IncompatibleTypesException extends RuntimeException{
    public IncompatibleTypesException(){
        super("O tipo de vaga deve ser compatível com o tipo do veículo.");
    }
}
