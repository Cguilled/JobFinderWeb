package com.cermeno.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cermeno.model.VacantPosition;
import com.cermeno.service.VacantService;

@Getter
@Setter
@Controller
@RequestMapping("/vacant")
public class VacantPositionController {

	@Autowired
	private VacantService vacantService;
	
//	Logger logger = Logger.getLogger(VacantsController.class);

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<VacantPosition> vacants = vacantService.findAll();
		model.addAttribute("vacant", vacants);
		return "vacant/listVacant";
	}

	@GetMapping("/create")
	public String create(VacantPosition vacantPosition) {
		
		return "vacant/formVacant";
	}

	@PostMapping("/save")
	public String save(VacantPosition vacant, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
//				logger.error(error.getDefaultMessage());
				System.err.println(error.getDefaultMessage());
			}
			return "vacant/formVacant";
		}
//		logger.info("Vacant: " + vacant.toString());
		System.out.println("Vacant: " + vacant.toString());
		vacantService.save(vacant);
		return "redirect:/vacant/index";
	}

	@GetMapping("/view/{id}")
	public String showDetail(@PathVariable("id") int vacantId, Model model) {
		Optional<VacantPosition> optVacant = vacantService.findById(vacantId);

		optVacant.ifPresent(vacant -> System.out.println("VacantPositionController, Id vacant: " + vacant.getId()));
		optVacant.ifPresent(vacant -> model.addAttribute("vacantPosition", vacant));

		// Search vacant detail in bbdd

		return "vacantDescription";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int vacantId, Model model) {
//		logger.info("Deleting vacant position id: " + vacantId);
		System.out.println("Deleting vacant position id: " + vacantId);
		model.addAttribute("id", vacantId);
		return "deletingMessage";
	}

	// Conversor de fechas de Spring
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}