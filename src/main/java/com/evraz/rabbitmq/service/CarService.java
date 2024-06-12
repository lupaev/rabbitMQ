package com.evraz.rabbitmq.service;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.dto.CarGenerator;
import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.mapper.CarLoadedMapper;
import com.evraz.rabbitmq.mapper.CarNotLoadedMapper;
import com.evraz.rabbitmq.producer.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.cl}")
    private String routingKeyForCarLoaded;

    @Value("${rabbitmq.routing.key.cnl}")
    private String routingKeyForCarNotLoaded;

    private final CarGenerator carGenerator;
    private final MessageSender messageSender;
    private final CarLoadedMapper carLoadedMapper;
    private final CarNotLoadedMapper carNotLoadedMapper;



    public void send() {
        CarDTO dto = carGenerator.generate();
        log.info("CarDTO generated: {}", dto);

        if (dto.getIsLoad() == 1) {
            CarLoaded entity = carLoadedMapper.toEntity(dto);
            messageSender.send(exchange,routingKeyForCarLoaded, entity);
            log.info("Car sent: {}", entity);
        }
        CarNotLoaded entity = carNotLoadedMapper.toEntity(dto);
        messageSender.send(exchange,routingKeyForCarNotLoaded, entity);
        log.info("Car sent: {}", entity);

    }
}
