package com.evraz.rabbitmq.consumer;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.entity.CarNum;
import com.evraz.rabbitmq.repository.CarLoadedRepository;
import com.evraz.rabbitmq.repository.CarNotLoadedRepository;
import com.evraz.rabbitmq.repository.CarNumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageReceiver {

    private final CarNotLoadedRepository carNotLoadedRepository;
    private final CarLoadedRepository carLoadedRepository;
    private final CarNumRepository carNumRepository;

    @RabbitListener(queues = {"${rabbitmq.queue.name.car.loaded}"})
    public void receiveCarLoaded(CarLoaded carLoaded) {
        log.info("CarLoaded received: {}", carLoaded);
        CarLoaded save = carLoadedRepository.save(carLoaded);
        log.info("CarLoaded saved: {}", save);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.car.not.loaded}"})
    public void receiveCarNotLoaded(CarNotLoaded carNotLoaded) {
        log.info("CarNotLoaded received: {}", carNotLoaded);
        CarNotLoaded save = carNotLoadedRepository.save(carNotLoaded);
        log.info("CarNotLoaded saved: {}", save);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name.car.factory.two}", "${rabbitmq.queue.name.car.factory.one}"})
    public void receiveCarNum(List<CarNum> carNum) {
        log.info("CarNum received: {}", carNum);
        List<CarNum> list = carNumRepository.saveAll(carNum);
        log.info("CarNum saved: {}", list);
    }

}
