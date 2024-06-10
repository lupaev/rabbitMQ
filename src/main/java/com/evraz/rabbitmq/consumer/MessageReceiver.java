package com.evraz.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReceiver {

    @RabbitListener(queues = "testQueue")
    public void receive(String in) {
        log.info("Received message: {}", in);
    }
}
