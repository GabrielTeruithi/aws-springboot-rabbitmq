package com.gteruithi.analise_credito.service.strategy;

import com.gteruithi.analise_credito.domain.Proposta;

public interface CalculoPontuacao {

    int calcular(Proposta proposta);
}
