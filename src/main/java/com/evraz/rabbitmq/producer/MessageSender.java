package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.entity.Car;
import com.evraz.rabbitmq.entity.CarNum;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, Car car) {
        rabbitTemplate.convertAndSend(exchange, routingKey, car);
    }

    public void send(String exchange, List<CarNum> carNumList) {
        rabbitTemplate.convertAndSend(exchange,"", carNumList);
    }

}
