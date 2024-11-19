package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class DemoApplication {

	private final List<Petition> petitions = new ArrayList<>();

	public DemoApplication() {
		// Initialize with some petitions
		petitions.add(new Petition(1, "Save the Endangered Species", "Protect endangered species from extinction."));
		petitions.add(new Petition(2, "Reduce Global Warming Impact", "Take action to minimize the effects of climate change."));
	}

	@GetMapping("/")
	public String createPetitionsForm(Model model) {
		model.addAttribute("petition", new Petition());
		return "index";
	}

	@PostMapping("/create-petition")
	public String createPetition(@RequestParam String title, @RequestParam String description) {
		int newId = petitions.size() + 1;
		petitions.add(new Petition(newId, title, description));
		return "redirect:/view";
	}

	@GetMapping("/view")
	public String viewPetitions(Model model) {
		model.addAttribute("petitions", petitions);
		return "view-petitions";
	}

	@GetMapping("/petition/{id}")
	public String viewPetition(@PathVariable int id, Model model) {
		Petition petition = findPetitionsById(id);
		if (petition == null) { return "error"; }
		model.addAttribute("petition", petition);
		return "view-petition";
	}

	@PostMapping("/petition/{id}/sign")
	public String signPetition(@PathVariable int id, @RequestParam String name, @RequestParam String email, Model model) {
		Petition petition = findPetitionsById(id);
		if (petition != null) {
			return "error";
		}
		String signature = name + " (" + email + ")";
		petition.addSignature(signature);
		model.addAttribute("petition", petition);
		return "redirect:/petition/" + id;
	}

	private Petition findPetitionsById(int id) {
		return petitions.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
