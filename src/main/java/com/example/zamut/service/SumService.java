package com.example.zamut.service;

import com.example.zamut.model.*;
import com.example.zamut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SumService {
    @Autowired
    private SumRepository sumRepository;
    
    @Autowired
    private InvoiceItemRepository invoiceRepository;

    public List<Sum> getAllSum() {
        return sumRepository.findAll();
    }
    public List<Sum> getAllSumOneConsumer(Consumer consumer) {
        return sumRepository.findAllByConsumer(consumer);
    }
    
    public List<Sum> getActiveSum() {
    	return sumRepository.getActiveSum();
    }
    
    public void saveInvoice(Map<String, String> params) {
    	
    }
}
