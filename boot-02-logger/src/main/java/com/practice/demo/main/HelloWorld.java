package com.practice.demo.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
	
	@GetMapping("/say")
	public String sayHello() {
		return "Hey... Hello!";
	}

}
