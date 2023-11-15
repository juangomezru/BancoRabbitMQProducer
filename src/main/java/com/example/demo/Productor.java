package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class Productor {

    RabbitTemplate rabbitTemplate;

    public Productor(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarJson(TransaccionDTO transaccionDTO) {
        rabbitTemplate.convertAndSend("banco", "transacciones", transaccionDTO);
    }
}
