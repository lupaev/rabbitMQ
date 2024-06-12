package com.evraz.rabbitmq.mapper;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.entity.CarLoaded;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarLoadedMapper {

    @Mapping(target = "id", ignore = true)
    CarLoaded toEntity(CarDTO carDTO);
}
