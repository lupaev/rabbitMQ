package com.evraz.rabbitmq.service;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.dto.CarGenerator;
import com.evraz.rabbitmq.dto.CarNumDTO;
import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.entity.CarNum;
import com.evraz.rabbitmq.mapper.CarLoadedMapper;
import com.evraz.rabbitmq.mapper.CarNotLoadedMapper;
import com.evraz.rabbitmq.mapper.CarNumMapper;
import com.evraz.rabbitmq.producer.MessageSender;
import com.evraz.rabbitmq.repository.CarNotLoadedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    @Value("${rabbitmq.fanout.exchange.name}")
    private String fanoutExchangeName;

    @Value("${rabbitmq.direct.exchange.name}")
    private String directExchangeName;

    @Value("${rabbitmq.routing.key.cl}")
    private String routingKeyForCarLoaded;

    @Value("${rabbitmq.routing.key.cnl}")
    private String routingKeyForCarNotLoaded;

    @Value("${rabbitmq.topic.exchange.name}")
    private String topicExchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKeyForLoadedCar;


    private final CarGenerator carGenerator;
    private final MessageSender messageSender;
    private final CarLoadedMapper carLoadedMapper;
    private final CarNotLoadedMapper carNotLoadedMapper;
    private final CarNotLoadedRepository carNotLoadedRepository;
    private final CarNumMapper carNumMapper;



    public void sendCar() {
        CarDTO dto = carGenerator.generate();
        log.info("CarDTO generated: {}", dto);

        if (dto.getIsLoad() == 1) {
            CarLoaded entity = carLoadedMapper.toEntity(dto);
            messageSender.send(directExchangeName, routingKeyForCarLoaded, entity);
            messageSender.send(topicExchangeName, routingKeyForLoadedCar, entity);
            log.info("CarLoaded sent: {}", entity);
        } else {
            CarNotLoaded entity = carNotLoadedMapper.toEntity(dto);
            messageSender.send(directExchangeName,routingKeyForCarNotLoaded, entity);
            log.info("CarNotLoaded sent: {}", entity);
        }

    }

    public void sendCarNumber() {
        List<CarNotLoaded> cars = carNotLoadedRepository.searchAllByCarNumContainingIgnoreCase("X");
        List<CarNumDTO> carNumDTOS = carNumMapper.toDtos(cars);
        List<CarNum> carNums = carNumMapper.toEntities(carNumDTOS);
        carNotLoadedRepository.deleteAll(cars);

        messageSender.send(fanoutExchangeName, carNums);
        log.info("CarNums sent: {}", carNums);
    }
}
