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

    public void send(String routingKey, CarLoaded car) {
        rabbitTemplate.convertAndSend(routingKey, car);
    }

    public void send(String routingKey, CarNotLoaded car) {
        rabbitTemplate.convertAndSend(routingKey, car);
    }
}
