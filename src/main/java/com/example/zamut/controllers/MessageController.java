package com.example.zamut.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zamut.model.Message;
import com.example.zamut.service.ConsumerService;
import com.example.zamut.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/add/consumer/message")
	public String addMessageForConsumer(Model model) {
		model.addAttribute("message", new Message());
		model.addAttribute("consumers", consumerService.getAllConsumers());
		return "message-form";
	}
	
	@PostMapping("/add/consumer/message")
	public void createMessageForConsumer(@ModelAttribute @Valid Message message,
			BindingResult result, Model model) {
		System.out.println(message);
		messageService.addMessage(message);
	}
}
