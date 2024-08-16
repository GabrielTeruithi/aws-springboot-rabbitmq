package com.gteruithi.analise_credito.service.strategy.impl;

import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoInferiorImpl implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 100 : 0;
    }
}
