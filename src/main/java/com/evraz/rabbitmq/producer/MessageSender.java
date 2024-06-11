package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.entity.Car;
import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(CarLoaded car, String routingKey) {
        rabbitTemplate.convertAndSend(routingKey, car.toString());
    }

    public void send(CarNotLoaded car, String routingKey) {
        rabbitTemplate.convertAndSend(routingKey, car.toString());
    }
}
