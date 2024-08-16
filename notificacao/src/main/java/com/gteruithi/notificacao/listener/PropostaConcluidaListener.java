package com.gteruithi.notificacao.listener;

import com.gteruithi.notificacao.constants.MensagemConstante;
import com.gteruithi.notificacao.domain.Proposta;
import com.gteruithi.notificacao.service.NotificacaoSNSService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {


    private NotificacaoSNSService notificacaoSNSService;

    public PropostaConcluidaListener(NotificacaoSNSService notificacaoSNSService) {
        this.notificacaoSNSService = notificacaoSNSService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta) {
        if (proposta.getAprovada()) {
            String mensagem = String.format(MensagemConstante.PROPOSTA_APROVADA, proposta.getUsuario().getNome());
            notificacaoSNSService.notificar(proposta.getUsuario().getTelefone(), mensagem);
        } else {
            String mensagem = String.format(MensagemConstante.PROPOSTA_NEGADA, proposta.getUsuario().getNome(), proposta.getObservacao());
            notificacaoSNSService.notificar(proposta.getUsuario().getTelefone(), mensagem);
        }
    }
}
