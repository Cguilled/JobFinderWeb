package com.cermeno.jobfinder.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cermeno.jobfinder.model.VacantPosition;
import com.cermeno.jobfinder.service.VacantServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
public class HomeController {

	private VacantServiceImpl vacantService;

	@Autowired
	public HomeController(VacantServiceImpl vacantService) {
		this.vacantService = vacantService;
	}

	@GetMapping("/")
	public String showHome(Model model) {
//		String job = "Auxiliar de contabilidad";
//		Date publicationDate = new Date();
//		double salary = 1200;
//		boolean active = true;
//		
//		model.addAttribute("job", job);
//		model.addAttribute("date", publicationDate);
//		model.addAttribute("salary", salary);
//		model.addAttribute("active", active);
		
		List<VacantPosition> vacants  = vacantService.findAll();
		model.addAttribute("vacantPositions", vacants);
		
		return "home";
	}
	
	@GetMapping("/jobTitles")
	public String showJobTitles(Model model) {
		List<String> jobTitles = new LinkedList<>();
		jobTitles.add("System Engineer");
		jobTitles.add("Backend Developer");
		jobTitles.add("Frontend Developer");
		jobTitles.add("Data Architect");
		
		model.addAttribute("jobs", jobTitles);
		return "jobTitles";
	}
	
	@GetMapping("/vacantDescription")
	public String showVacantDescription(Model model) {
		VacantPosition vacant = new VacantPosition();
		vacant.setName("Telecommunication engineer");
		vacant.setDescription("Needed a telecommunication engineer who supports intranet infrastructure");
		vacant.setDate(new Date());
		vacant.setSalary(1500.0);
		
		model.addAttribute("vacantPosition", vacant);
		return "vacantDescription";
	}
	
	@GetMapping("vacantPositions")
	public String showVacantPositions(Model model) {
		List<VacantPosition> vacants  = vacantService.findAll();
		model.addAttribute("vacantPositions", vacants);
		return "vacantPositions";
	}
}