--liquibase formatted sql

--changeset sergej:1
CREATE TABLE CAR_NUM
(
    ID             BIGSERIAL                     PRIMARY KEY,
    CAR_NUM        VARCHAR(20)                   NOT NULL,
    INVOICE_NUM    VARCHAR(25)
);
