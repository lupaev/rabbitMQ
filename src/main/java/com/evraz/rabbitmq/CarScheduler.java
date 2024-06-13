package com.evraz.rabbitmq;

import com.evraz.rabbitmq.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class CarScheduler {

    private final CarService carService;

    @Scheduled(fixedRate = 20000)
    public void run1() {
        try {
            carService.sendCar();
        } catch (Exception error) {
            log.error(error.getMessage());
        }
    }

    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 1)
    public void run2() {
        try {
            carService.sendCarNumber();
        } catch (Exception error) {
            log.error(error.getMessage());
        }
    }
}
