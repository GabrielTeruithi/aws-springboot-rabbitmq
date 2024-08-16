package com.gteruithi.analise_credito.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;

}
