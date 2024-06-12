package com.evraz.rabbitmq;

import com.evraz.rabbitmq.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class CarScheduler {

    private final CarService carService;

    @Scheduled(fixedRate = 10000)
    public void run() {
        try {
            carService.sendCar();
        } catch (Exception error) {
            log.error(error.getMessage());
        }
    }
}
