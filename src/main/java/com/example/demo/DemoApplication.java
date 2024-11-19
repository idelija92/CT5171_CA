package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final List<Petition> petitions = new ArrayList<>();

	public DemoApplication() {
		// Initialize with some petitions
		petitions.add(new Petition(1, "Save the Endangered Species", "Protect endangered species from extinction."));
		petitions.add(new Petition(2, "Reduce Global Warming Impact", "Take action to minimize the effects of climate change."));
	}

	@GetMapping("/")
	public String createPetitions() {
		return "This is a landing page placeholder for creating petitions";
	}

	@GetMapping("/view")
	public List<Petition> viewPetitions() {
		return petitions;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
