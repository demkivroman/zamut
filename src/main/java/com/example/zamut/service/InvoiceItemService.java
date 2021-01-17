package com.example.zamut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zamut.model.InvoiceItem;
import com.example.zamut.repository.InvoiceItemRepository;

@Service
public class InvoiceItemService {
	
	@Autowired
	private InvoiceItemRepository invoiceRepository;
	
	public List<InvoiceItem> getAll() {
		return invoiceRepository.findAll();
	}
}
