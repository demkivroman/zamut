package com.example.zamut.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.zamut.model.Sum;
import com.example.zamut.repository.ConsumerRepository;
import com.example.zamut.repository.SumRepository;
import com.example.zamut.service.InvoiceItemService;
import com.example.zamut.service.SumService;

import com.example.zamut.util.*;

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
	
	@PostMapping("/add/consumer/{consumer_id}/invoice")
	public String addInvoice( @PathVariable("consumer_id") long id,
			@RequestParam Map<String,String> allParams) {
		
		sumService.saveInvoice(allParams, id);
		return "redirect:/";
	}
	
}
