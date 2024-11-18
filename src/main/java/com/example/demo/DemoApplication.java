package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/")
	public String createPetitions() { return "This is a landing page placeholder for creating petitions"; }

	@RequestMapping("/view")
	public String viewPetitions() { return "Here you can see all petitions"; }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
