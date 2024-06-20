package com.evraz.rabbitmq.mapper;

import com.evraz.rabbitmq.dto.CarNumDTO;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import com.evraz.rabbitmq.entity.CarNum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CarNumMapper {


    @Mapping(target = "carNum", source = "carNum")
    @Mapping(target = "invoiceNum", source = "invoiceNum")
    CarNumDTO toDto(CarNotLoaded carNotLoaded);

    List<CarNumDTO> toDtos(List<CarNotLoaded> carNotLoaded);

    CarNum toEntity(CarNumDTO carNumDTO);

    List<CarNum> toEntities(List<CarNumDTO> carNumDTO);

}
