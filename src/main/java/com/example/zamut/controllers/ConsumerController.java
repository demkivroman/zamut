package com.example.zamut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.zamut.model.Consumer;
import com.example.zamut.service.ConsumerService;
import com.example.zamut.service.SumService;

@Controller
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private SumService sumService;
	
	@GetMapping("/all/cunsumers")
	public String allConsumers(Model model) {
		model.addAttribute("consumers", consumerService.getAllConsumers());
		model.addAttribute("activeSums", sumService.getActiveSum());
		return "all-consumers";
	}
	
	@GetMapping("/add/consumer")
	public String showSignUpForm(Model model) {
		model.addAttribute("consumer", new Consumer());
		return "add-consumer-form";
	}
	
	@PostMapping("/add/consumer")
	public String addConsumer(@Validated @ModelAttribute("consumer") Consumer consumer,
			BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldError());
		}
		
		consumerService.saveConsumer(consumer);
		return "redirect:/";
	}
}
