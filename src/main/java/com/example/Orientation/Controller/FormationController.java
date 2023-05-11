package com.example.Orientation.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Orientation.entities.Formation;



import com.example.Orientation.Dao.FormationRepository;

@Controller

public class FormationController {
	
	@Autowired
	FormationRepository formationRepository;
	
	
	@RequestMapping(value = "Formation")
	public String Formation(Model model) {
		List<Formation> formations = formationRepository.findAll();
		model.addAttribute("formations", formations);
		return "Formation";
	}


	@RequestMapping(value = "/home")
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/modifier" , method= RequestMethod.GET)
	public String edit(Model model , Long id ) {
		Formation m = formationRepository.getById(id);
		model.addAttribute("formation", m);
		return "formMetier";
		
	}
	@RequestMapping(value = "/supp" , method = RequestMethod.GET)
	public String delete(Long id) {
		formationRepository.deleteById(id);
		return "redirect:/Formation";
	}
	
	//
	@RequestMapping(value = "/saveformation", method = RequestMethod.GET)
	public String f(Model model) {
		model.addAttribute("formation", new Formation());
		return "saveformation";
	}
	@RequestMapping(value = "/s", method = RequestMethod.POST)
	public String s(Model model , Formation formation) {
		formationRepository.save(formation);
		return "redirect:/Formation";
	}
	
//	@RequestMapping(value = "/formation/{metier_id}")
//	public String test(@PathVariable Long metier_id, Model model) {
//        model.addAttribute("formations", formationRepository.getFomationsBymetier(metier_id));
//		return "tst";
//	}
	
}
