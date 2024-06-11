package com.evraz.rabbitmq.mapper;

import com.evraz.rabbitmq.dto.CarDTO;
import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarLoadedMapper {

    @Mapping(target = "id", ignore = true)
    CarLoaded toEntity(CarDTO carDTO);

    List<CarLoaded> toEntities(List<CarDTO> carDTOList);

}
