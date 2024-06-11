package com.evraz.rabbitmq.repository;

import com.evraz.rabbitmq.entity.CarLoaded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarLoadedRepository extends JpaRepository<CarLoaded, Long> {
}
