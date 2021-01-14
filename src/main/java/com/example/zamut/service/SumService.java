package com.example.zamut.service;

import com.example.zamut.model.*;
import com.example.zamut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SumService {
    @Autowired
    private SumRepository sumRepository;

    public List<Sum> getAllSum() {
        return sumRepository.findAll();
    }
    public List<Sum> getAllSumOneConsumer(Consumer consumer) {
        return sumRepository.findAllByConsumer(consumer);
    }
}
