package com.example.zamut.repository;

import com.example.zamut.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SumRepository extends JpaRepository<Sum,Long> {
	List<Sum> findAllByConsumerAndAmountGreaterThan(Consumer consumer, double value);
    List<Sum> findAllByConsumer(Consumer consumer);
}
