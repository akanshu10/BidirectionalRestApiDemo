package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

	@PostMapping("/h1")
	public void print() {
		System.out.println("This is hi ..");
	}
	
	@GetMapping("/h2")
	public void print2() {
		System.out.println("This is hi2 ..");
	}
	
	
}
