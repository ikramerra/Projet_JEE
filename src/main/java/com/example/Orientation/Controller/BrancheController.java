package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.Orientation.Dao.BrancheRepository;
import com.example.Orientation.Dao.FormationRepository;
import com.example.Orientation.Dao.ProjetRepository;


@Controller
public class BrancheController {
	
	@Autowired
	BrancheRepository brancherepository;
	
	@Autowired
	FormationRepository  formationRepository ;
	
	@Autowired
	ProjetRepository projetRepository;
	
	//pour la liste des branches
	
	
	@RequestMapping(value = "/BranchesParFormation")
	public String getbranche(Model model,@RequestParam(value = "id") Long id) {
		
		
		  String nomFormation = formationRepository.findById(id).get().getNom_formation();
		
		  model.addAttribute("nomFormation",nomFormation);
		  model.addAttribute("branches", brancherepository.getBranchrByFormation(id));
		  
		  return "BranchesParFormation";
	  }
	
	

}
