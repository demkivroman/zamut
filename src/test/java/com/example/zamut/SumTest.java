package com.example.zamut;


import com.example.zamut.model.*;
import com.example.zamut.repository.SumRepository;
import com.example.zamut.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SumTest {
    @Autowired
    private SumService sumService;
    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private SumRepository sumRepository;
    
    @Test
    public void whenCheckGetAllSum() {
        List<Sum> sums = sumService.getAllSum();
        Assertions.assertEquals(3, sums.size());
    }
    @Test
    public void whenCheckGetAllSumOneConsumer() {
        Consumer consumer = consumerService.getById(1);
        List<Sum> sums = sumService.getAllSumOneConsumer(consumer);
        Assertions.assertEquals(sums.size(), 2);
    }
    
    @Test
    public void whenCheckConsumerSumIsGreaterThanNull() {
    	Consumer consumer = consumerService.getById(1);
    	List<Sum> sums = sumRepository.findAllByConsumerAndAmountGreaterThan(consumer, 0d);
    	Assertions.assertEquals(sums.size(), 2);
    }
    
}
