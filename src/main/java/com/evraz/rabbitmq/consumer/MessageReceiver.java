package com.evraz.rabbitmq.consumer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageReceiver {

//    private final CarNotLoadedRepository carNotLoadedRepository;
//    private final CarLoadedRepository carLoadedRepository;
//
//    @RabbitListener(queues = "loaded")
//    public void receiveCarLoaded(CarLoaded carLoaded) {
//        log.info("Car received: {}", carLoaded);
//        CarLoaded save = carLoadedRepository.save(carLoaded);
//        log.info("Car saved: {}", save);
//    }
//
//    @RabbitListener(queues = "notLoaded")
//    public void receiveCarNotLoaded(CarNotLoaded carNotLoaded) {
//        log.info("Car received: {}", carNotLoaded);
//        CarNotLoaded save = carNotLoadedRepository.save(carNotLoaded);
//        log.info("Car saved: {}", save);
//    }

    @RabbitListener(queues = "${queue.for.loaded.car}")
    public void receiveLoadedCar(CarLoaded car) {
        // Обработка полученного объекта CarLoaded
        log.info("Received loaded car: {}", car);
    }

    @RabbitListener(queues = "${queue.for.not.loaded.car}")
    public void receiveNotLoadedCar(CarNotLoaded car) {
        // Обработка полученного объекта CarNotLoaded
        log.info("Received not loaded car: {}", car);
    }

}
