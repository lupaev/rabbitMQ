package com.evraz.rabbitmq.repository;

import com.evraz.rabbitmq.entity.CarNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarNumRepository extends JpaRepository<CarNum, Long> {
}
