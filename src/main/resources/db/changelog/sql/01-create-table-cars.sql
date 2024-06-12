--liquibase formatted sql

--changeset sergej:1
CREATE TABLE CAR_LOADED
(
    ID             BIGSERIAL                     PRIMARY KEY,
    CAR_NUM        VARCHAR(20)                   NOT NULL,
    INVOICE_NUM    VARCHAR(25),
    SHIP_DATE      DATE,
    CONTRACT_NUM   VARCHAR(20),
    IS_LOAD        INT
);

--changeset sergej:2
CREATE TABLE CAR_NOT_LOADED
(
    ID             BIGSERIAL                     PRIMARY KEY,
    CAR_NUM        VARCHAR(20)                   NOT NULL,
    INVOICE_NUM    VARCHAR(25),
    SHIP_DATE      DATE,
    CONTRACT_NUM   VARCHAR(20),
    IS_LOAD        INT
)
