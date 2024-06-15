package com.evraz.rabbitmq.producer;

import com.evraz.rabbitmq.entity.Car;
import com.evraz.rabbitmq.entity.CarNum;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void send(String exchange, Car car, Map<String, Object> headers) {
        rabbitTemplate.convertAndSend(exchange, "", car, m -> {
            m.getMessageProperties().getHeaders().putAll(headers);
            return m;
        });
    }

}
