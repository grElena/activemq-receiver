package com.example.activemqreceiver.consumer;

import com.example.activemqreceiver.domain.Message;
import com.example.activemqreceiver.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
@EnableJms

public class MessageConsumer {
    private MessageService service;
    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    public MessageConsumer(@Qualifier("messageService") MessageService service) {
        this.service = service;
    }

    @JmsListener(destination = "test-queue")
    public void listener(String message){
        logger.info("Message received {} ", message);
        Message messageReceived = new Message();
        messageReceived.setMessage(message);
        service.save(messageReceived);
    }
}
