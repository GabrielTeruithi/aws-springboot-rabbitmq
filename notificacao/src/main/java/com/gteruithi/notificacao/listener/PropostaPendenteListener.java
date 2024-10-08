package com.gteruithi.notificacao.listener;

import com.gteruithi.notificacao.constants.MensagemConstante;
import com.gteruithi.notificacao.domain.Proposta;
import com.gteruithi.notificacao.service.NotificacaoSNSService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {


    private NotificacaoSNSService notificacaoSNSService;

    public PropostaPendenteListener(NotificacaoSNSService notificacaoSNSService) {
        this.notificacaoSNSService = notificacaoSNSService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta) {
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSNSService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
