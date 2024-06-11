package com.evraz.rabbitmq.consumer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.repository.CarLoadedRepository;
import com.evraz.rabbitmq.repository.CarNotLoadedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageReceiver {

    private final CarNotLoadedRepository carNotLoadedRepository;
    private final CarLoadedRepository carLoadedRepository;

    @RabbitListener(queues = "#{@queueForLoadedCar.name}")
//    @RabbitListener(queues = "loaded")
    public void receiveCarLoaded(String message) {
        log.info("Car received: {}", message);
    }

//    public void receiveCarLoaded(CarLoaded carLoaded) {
//        log.info("Car received: {}", carLoaded);
//        CarLoaded save = carLoadedRepository.save(carLoaded);
//        log.info("Car saved: {}", save);
//    }

    @RabbitListener(queues = "#{@queueForNotLoadedCar.name}")
//    @RabbitListener(queues = "notLoaded")
    public void receiveCarNotLoaded(String message) {
        log.info("Car received: {}", message);
    }

//    public void receiveCarNotLoaded(CarNotLoaded carNotLoaded) {
//        log.info("Car received: {}", carNotLoaded);
//        CarNotLoaded save = carNotLoadedRepository.save(carNotLoaded);
//        log.info("Car saved: {}", save);
//    }
}
