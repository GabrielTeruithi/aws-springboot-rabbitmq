package com.gteruithi.propostaapp.service;

import com.gteruithi.propostaapp.dto.PropostaResponseDTO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private SimpMessagingTemplate template;

    public WebSocketService(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void notificar(PropostaResponseDTO propostaResponseDTO){
        template.convertAndSend("/propostas", propostaResponseDTO);
    }
}
