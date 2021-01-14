package com.example.zamut;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.zamut.model.*;
import com.example.zamut.service.*;

@SpringBootTest
public class ConsumerTest {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Test
	public void whenTestGetAllConsumers() {
		List<Consumer> list = consumerService.getAllConsumers();
		Assertions.assertEquals(list.size(), 3);
	}
}
