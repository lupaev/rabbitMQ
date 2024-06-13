package com.evraz.rabbitmq.repository;

import com.evraz.rabbitmq.entity.Car;
import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarNotLoadedRepository extends JpaRepository<CarNotLoaded, Long> {

    List<CarNotLoaded> searchAllByCarNumContainingIgnoreCase(String carNum);
}
