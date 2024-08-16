package com.gteruithi.notificacao.domain;

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
