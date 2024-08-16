package com.gteruithi.analise_credito.service.strategy.impl;

import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.stereotype.Component;

@Component
public class RendaMaiorValorSolicitado implements CalculoPontuacao {
    @Override
    public int calcular(Proposta proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorValorSolicitado(Proposta proposta) {
       return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }

}
