package com.gteruithi.analise_credito.service;

import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.exceptions.StrategyException;
import com.gteruithi.analise_credito.service.strategy.CalculoPontuacao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnaliseCreditoService {

    private List<CalculoPontuacao> calculoPontoList;

    private NotificacaoRabbitMQService notificacaoRabbitService;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public AnaliseCreditoService(List<CalculoPontuacao> calculoPontoList, NotificacaoRabbitMQService notificacaoRabbitService) {
        this.calculoPontoList = calculoPontoList;
        this.notificacaoRabbitService = notificacaoRabbitService;
    }

    public void analisar(Proposta proposta) {
        try {
            int pontos = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovada(pontos > 350);
        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitService.notificar(exchangePropostaConcluida, proposta);
    }
}
