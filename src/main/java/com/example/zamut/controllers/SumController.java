package com.example.zamut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.zamut.service.InvoiceItemService;
import com.example.zamut.service.SumService;

@Controller
public class SumController {
	
	@Autowired
	private SumService sumService;
	
	@Autowired
	private InvoiceItemService invoiceService;
	
	
	@GetMapping("/consumer/{consumer_id}/invoice")
	public String formInvoice(@PathVariable("consumer_id") long consId, Model model) {
		model.addAttribute("consumerId", consId);
		model.addAttribute("items", invoiceService.getAll());
		return "add-invoice";
	}
}
