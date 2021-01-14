package com.example.zamut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zamut.model.Consumer;
import com.example.zamut.service.ConsumerService;

@Controller
public class MainController {
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
}