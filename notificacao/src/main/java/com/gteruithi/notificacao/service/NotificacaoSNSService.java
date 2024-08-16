package com.gteruithi.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSNSService {

    private AmazonSNS amazonSNS;

    public NotificacaoSNSService(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    public void notificar(String telefone, String mensagem) {
        PublishRequest publishRequest = new PublishRequest().withMessage(mensagem).withPhoneNumber(telefone);
        amazonSNS.publish(publishRequest);
        System.out.println(mensagem + telefone);
        System.out.println(publishRequest);
    }

}
