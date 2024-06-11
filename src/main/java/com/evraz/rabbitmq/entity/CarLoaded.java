package com.evraz.rabbitmq.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "CAR_LOADED")
public class CarLoaded implements Car, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CAR_NUM")
    private String carNum;

    @Column(name = "INVOICE_NUM")
    private String invoiceNum;

    @Column(name = "SHIP_DATE")
    private LocalDate shipDate;

    @Column(name = "CONTRACT_NUM")
    private String contractNum;

    @Column(name = "IS_LOAD")
    private Integer isLoad;

}
