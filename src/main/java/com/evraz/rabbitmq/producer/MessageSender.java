package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, CarLoaded car) {
        rabbitTemplate.convertAndSend(exchange, routingKey, car);
    }

    public void send(String exchange, String routingKey, CarNotLoaded car) {
        rabbitTemplate.convertAndSend(exchange, routingKey, car);
    }
}
