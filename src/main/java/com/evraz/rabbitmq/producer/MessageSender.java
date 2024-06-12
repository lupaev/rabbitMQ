package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, Car car) {
        rabbitTemplate.convertAndSend(exchange, routingKey, car);
    }

}
