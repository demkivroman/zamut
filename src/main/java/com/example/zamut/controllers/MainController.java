package com.example.zamut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.zamut.model.Consumer;
import com.example.zamut.service.ConsumerService;
import com.example.zamut.service.SumService;

@Controller
public class MainController {
	
	@Autowired
	private ConsumerService ConsumerService;
	
	@Autowired
	private SumService sumService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("activeSums", sumService.getActiveSum());
		return "welcome";
	}
	
}