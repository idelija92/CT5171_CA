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

	@PostMapping("/create")
	public String createPetition(@RequestParam String title, @RequestParam String description) {
		int id = petitions.size() + 1;
		petitions.add(new Petition(id, title, description));
		return "Petition created successfully with ID: " + id;
	}

	@GetMapping("/petition/{id}")
	public Petition viewPetition(@PathVariable int id) {
		return petitions.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null); // Returns the petition as JSON or `null` if not found
	}

	@PostMapping("/petition/{id}/sign")
	public String signPetition(@PathVariable int id, @RequestParam String name, @RequestParam String email) {
		Petition petition = petitions.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);

		if (petition != null) {
			petition.addSignature(name, email);
			return "Signed petition with ID: " + id;
		}
		return "Petition not found.";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
