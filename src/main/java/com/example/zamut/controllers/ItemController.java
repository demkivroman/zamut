package com.example.zamut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zamut.model.InvoiceItem;
import com.example.zamut.service.InvoiceItemService;
import com.example.zamut.service.SumService;

@Controller
public class ItemController {
	
	@Autowired
	private InvoiceItemService invoiceService; 
	
	@Autowired
	private SumService sumService;
	
	@GetMapping("/consumer/{consumer_id}/invoice/add/item")
	public String addItem(@PathVariable("consumer_id") long consumerId,
			Model model) {
		model.addAttribute("item", new InvoiceItem());
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("activeSums", sumService.getActiveSum());
		return "add-item";
	}
	
	@PostMapping("/consumer/{consumer_id}/invoice/add/item")
	public String saveItem(@Validated @ModelAttribute("item") InvoiceItem item,
			BindingResult result, @PathVariable("consumer_id") long consumerId) {
		System.out.println(item + "yoьдьддьдьдьдьдьдьдьдьдьддьльд");
		if (!result.hasErrors()) {
			invoiceService.save(item);
		}
		return "redirect:/consumer/" + consumerId + "/invoice";
	}
}
