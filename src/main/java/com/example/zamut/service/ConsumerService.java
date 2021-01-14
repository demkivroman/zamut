package com.example.zamut.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zamut.dto.ConsumerDTO;
import com.example.zamut.model.*;
import com.example.zamut.repository.*;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository repository;
	
	public List<Consumer> getAllConsumers() {
		return repository.findAll();
	}
	public Consumer getById(long id) {
		return repository.findById(id).get();
	}
	
	public void saveConsumer(Consumer consumer) {
		repository.save(consumer);
	}
	
}
