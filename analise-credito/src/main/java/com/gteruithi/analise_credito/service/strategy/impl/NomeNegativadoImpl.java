package com.gteruithi.analise_credito.service.strategy.impl;

import com.gteruithi.analise_credito.constants.MensagemConstante;
import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.exceptions.StrategyException;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPontuacao {

    @Override
    public int calcular(Proposta proposta) {
        if (nomeNegativado()) {
            throw new StrategyException(String.format(MensagemConstante.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }
        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }
}
