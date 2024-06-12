package com.evraz.rabbitmq.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
public class CarDTO {

    private String carNum;
    private String invoiceNum;
    private LocalDate shipDate;
    private String contractNum;
    private Integer isLoad;

}
