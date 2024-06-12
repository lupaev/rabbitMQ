package com.evraz.rabbitmq.dto;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;


@Component
public class CarGenerator {

    private final Random random = new Random();

    public CarDTO generate() {
        CarDTO dto = new CarDTO();
        dto.setCarNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setInvoiceNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setShipDate(LocalDate.now().minusDays(random.nextInt(365)));
        dto.setContractNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setIsLoad(random.nextInt(2));
        return dto;
    }
}
