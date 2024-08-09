package com.gteruithi.analise_credito.service.strategy.impl;

import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoImpl implements CalculoPontuacao {

    @Override
    public int calcular(Proposta proposta) {
        return outrosEmprestimosEmAndamento() ? 0 : 100;
    }

    private boolean outrosEmprestimosEmAndamento() {
        return new Random().nextBoolean();

    }
}
