package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Orientation.Dao.MaladieRepository;
import com.example.Orientation.entities.Maladie;
@Controller
public class MaladieController {
	
	
	
	@Autowired
	MaladieRepository maladieRepository;
	
	@GetMapping(value  = "/get")
	public String maladies(Model model) {
		List<Maladie> maladies =  maladieRepository.findAll();
		model.addAttribute("maladies", maladies);
		return "inscrpcandidat";
	}
	@PostMapping(path = "/get")
	private String submitEmployee(@ModelAttribute("maladie") Maladie maladie, Model model) {
		model.addAttribute("data", maladie.toString());

		return "Confirmation";
	}
	

}
