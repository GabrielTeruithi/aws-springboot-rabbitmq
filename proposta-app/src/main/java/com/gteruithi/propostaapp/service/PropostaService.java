package com.gteruithi.propostaapp.service;

import com.gteruithi.propostaapp.dto.PropostaRequestDTO;
import com.gteruithi.propostaapp.dto.PropostaResponseDTO;
import com.gteruithi.propostaapp.entity.Proposta;
import com.gteruithi.propostaapp.mapper.PropostaMapper;
import com.gteruithi.propostaapp.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    private final String exchange;
    private PropostaRepository propostaRepository;
    private NotificacaoRabbitService notificacaoRabbitService;

    public PropostaService(@Value("${rabbitmq.propostapendente.exchange}") String exchange, PropostaRepository propostaRepository, NotificacaoRabbitService notificacaoRabbitService) {
        this.exchange = exchange;
        this.propostaRepository = propostaRepository;
        this.notificacaoRabbitService = notificacaoRabbitService;
    }

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {

        Proposta proposta = PropostaMapper.INSTANCE.convertRequestDtoToPropostaEntity(requestDTO);
        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);

        return PropostaMapper.INSTANCE.convertPropostaEntityToResponseDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificacaoRabbitService.notificar(proposta, exchange);

        } catch (RuntimeException ex) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDTO> findAll() {
        return PropostaMapper.INSTANCE.convertPropostaListEntityToResponseDtoList(propostaRepository.findAll());

    }
}
