package com.evraz.rabbitmq.repository;

import com.evraz.rabbitmq.entity.CarLoaded;
import com.evraz.rabbitmq.entity.CarNotLoaded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarNotLoadedRepository extends JpaRepository<CarNotLoaded, Long> {
}
