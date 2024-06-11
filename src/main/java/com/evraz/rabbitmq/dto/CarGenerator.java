package com.evraz.rabbitmq.dto;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;


@Component
public class CarGenerator {

    public CarDTO generate() {
        CarDTO dto = new CarDTO();
        dto.setCarNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setInvoiceNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setShipDate(LocalDate.now().minusDays(new Random().nextInt(365)));
        dto.setContractNum(RandomStringUtils.randomAlphanumeric(10));
        dto.setIsLoad(new Random().nextInt(2));
        return dto;
    }
}
