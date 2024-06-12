package com.evraz.rabbitmq.mapper;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarNotLoadedMapper {

    @Mapping(target = "id", ignore = true)
    CarNotLoaded toEntity(CarDTO carDTO);
}
