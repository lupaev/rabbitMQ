package com.evraz.rabbitmq.consumer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.repository.CarLoadedRepository;
import com.evraz.rabbitmq.repository.CarNotLoadedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageReceiver {

    private final CarNotLoadedRepository carNotLoadedRepository;
    private final CarLoadedRepository carLoadedRepository;

    @RabbitListener(queues = {"queue"})
    public void receiveCarLoaded(CarLoaded carLoaded) {
        log.info("CarLoaded received: {}", carLoaded);
        CarLoaded save = carLoadedRepository.save(carLoaded);
        log.info("CarLoaded saved: {}", save);
    }

    @RabbitListener(queues = {"queue"})
    public void receiveCarNotLoaded(CarNotLoaded carNotLoaded) {
        log.info("CarNotLoaded received: {}", carNotLoaded);
        CarNotLoaded save = carNotLoadedRepository.save(carNotLoaded);
        log.info("CarNotLoaded saved: {}", save);
    }

}
