package com.gteruithi.analise_credito.service.strategy.impl;

import com.gteruithi.analise_credito.constants.MensagemConstante;
import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.exceptions.StrategyException;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoCoreImpl implements CalculoPontuacao {

    @Override
    public int calcular(Proposta proposta) {
        int score = score();
        if (score < 200) {
            throw new StrategyException(String.format(MensagemConstante.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
        } else if (score <= 400) {
            return 150;
        } else if (score <= 1600) {
            return 200;
        } else {
            return 200;
        }
    }

    private int score() {
        return new Random().nextInt(0, 1000);
    }

}
