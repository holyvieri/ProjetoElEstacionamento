package com.upe.ProjetoElEstacionamento.exceptions;

public class IncompatiblePreferentialsException extends RuntimeException {
    public IncompatiblePreferentialsException(){
        super("O critério de preferencialidade deve ser compatível tanto com o veículo quanto com a vaga escolhida.");
    }

}
