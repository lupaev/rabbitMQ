package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String exchenge, String routingKey, CarLoaded car) {
//        Message message = new Message(car.toString().getBytes(StandardCharsets.UTF_8));
        rabbitTemplate.convertAndSend(exchenge, routingKey, car);
    }

    public void send(String exchenge, String routingKey, CarNotLoaded car) {
//        Message message = new Message(car.toString().getBytes(StandardCharsets.UTF_8));
        rabbitTemplate.convertAndSend(exchenge, routingKey, car);
    }
}
