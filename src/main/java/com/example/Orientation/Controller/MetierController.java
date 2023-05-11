package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Orientation.Dao.MetierRepository;
import com.example.Orientation.Dao.SecteurRepository;
import com.example.Orientation.entities.Formation;
import com.example.Orientation.entities.Metier;
@Controller
public class MetierController {
	
	@Autowired
	MetierRepository metierRepository;
	
	@Autowired
	SecteurRepository secteurRepository; 
	
	@RequestMapping(value = "/metiers")
	public String metiers( Model model,@RequestParam(name = "page", defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "8")int size) {
			
			Page<Metier> pagemetiers = metierRepository.findAll(PageRequest.of(page, size));
		
			model.addAttribute("pagemetiers", pagemetiers);
			int[] pages = new int[pagemetiers.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("size", size);
			model.addAttribute("page", page);
		return "metiers";
	}
	
	@RequestMapping(value = "/mesMetiers")
	public String mesMetiers(Model model) {
			
			List<Metier> mesmetiers = metierRepository.getMetierByRiasec(18L);
			model.addAttribute("pagemetiers", mesmetiers);
			
		return "Mes_metiers";
	}
	
	@RequestMapping(value = "/metierss")
	public String metierss( Model model) {
		List<Metier> metiers = metierRepository.findAll();
		model.addAttribute("listmetiers",metiers);
		return "metiers";
	}
	@RequestMapping(value = "/delete" , method = RequestMethod.GET)
	public String delete(Long id) {
		metierRepository.deleteById(id);
		return "redirect:/metiers";
			
	}
    
	@RequestMapping(value = "/Confirmation")
	public String Confirmation(Model model) {
		return "Confirmation";
		
	}
	
	@RequestMapping(value = "/edit" , method= RequestMethod.GET)
	public String edit(Model model , Long id ) {
		Metier m = metierRepository.getById(id);
		model.addAttribute("metier", m);
		model.addAttribute("secteurs", secteurRepository.findAll());
		return "metiers";
		
	}
	@RequestMapping(value = "/savemet", method = RequestMethod.POST)
	public String ss(Model model , Metier metier) {
		metierRepository.save(metier);
		
		
		return "redirect:/metiers";
	}
	
	
	@RequestMapping(value = "/index")
	public String index() {
		
		return "index";
	}
	@RequestMapping(value = "/test2")
	public String jj() {
		
		return "test2";
	}


	@RequestMapping(value = "/savemetier", method = RequestMethod.GET)
	public String f(Model model) {
		model.addAttribute("metier", new Metier());
		model.addAttribute("secteurs",secteurRepository.findAll());
		return "savemetier";
	}
	
	@RequestMapping(value = "/savemetier2", method = RequestMethod.POST)
	public String s(Model model , Metier metier) {
		metierRepository.save(metier);
		
		
		return "redirect:/metiers";
	}
	
//	@RequestMapping(value = "/test/{reasic_id}")
//	public String test(@PathVariable Long reasic_id, Model model) {
//        model.addAttribute("metiers", metierRepository.getMetierByRiasec(reasic_id));
//		return "tst";
//	}
//	
	
}
