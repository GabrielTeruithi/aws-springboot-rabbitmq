package com.gteruithi.analise_credito.Listener;

import com.gteruithi.analise_credito.domain.Proposta;
import com.gteruithi.analise_credito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    private final AnaliseCreditoService analiseCreditoService;

    public PropostaEmAnaliseListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }
}