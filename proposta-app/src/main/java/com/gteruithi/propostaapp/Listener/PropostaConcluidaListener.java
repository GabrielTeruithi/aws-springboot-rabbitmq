package com.gteruithi.propostaapp.Listener;

import com.gteruithi.propostaapp.entity.Proposta;
import com.gteruithi.propostaapp.mapper.PropostaMapper;
import com.gteruithi.propostaapp.repository.PropostaRepository;
import com.gteruithi.propostaapp.service.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    private PropostaRepository propostaRepository;

    private WebSocketService webSocketService;

    public PropostaConcluidaListener(PropostaRepository propostaRepository, WebSocketService webSocketService) {
        this.propostaRepository = propostaRepository;
        this.webSocketService = webSocketService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(Proposta proposta) {
       webSocketService.notificar(PropostaMapper.INSTANCE.convertPropostaEntityToResponseDto(proposta));
       propostaRepository.atualizarProposta(proposta.getId(), proposta.getAprovada(), proposta.getObservacao());
    }
}