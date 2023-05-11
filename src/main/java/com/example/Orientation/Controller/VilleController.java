package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Orientation.Dao.VilleRepository;
import com.example.Orientation.entities.Ville;

@Controller

public class VilleController {
	
	@Autowired
	VilleRepository villeRepository;
	
//	@RequestMapping
//	public String villes(Model model) {
//		
//		List<Ville> villes = villeRepository.findAll();
//		model.addAttribute("villes", villes);
//		return "";
//				
//				}

}
