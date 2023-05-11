package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Orientation.Dao.BrancheRepository;
import com.example.Orientation.Dao.EtablissementRepository;
import com.example.Orientation.Dao.GenreRepository;
import com.example.Orientation.Dao.TypeRepository;
import com.example.Orientation.Dao.UniversityRepository;
import com.example.Orientation.Dao.VilleRepository;
import com.example.Orientation.entities.Etablissement;
import com.example.Orientation.entities.Formation;
import com.example.Orientation.entities.Metier;
@Controller
public class EtablissementController {
	
	@Autowired
	EtablissementRepository etablissementRepository;
	
	@Autowired
	BrancheRepository brancheRepository;
	@Autowired
	VilleRepository villeRepository; 
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	UniversityRepository universityRepository; 
	@Autowired
	GenreRepository genreRepository; 
	
	@RequestMapping(value = "/listesetablissements")
		public String Etqb(Model model  ,@RequestParam(name = "page", defaultValue = "0")int page,
				@RequestParam(name = "size", defaultValue = "8")int size) {
				
				Page<Etablissement> pagesetbs = etablissementRepository.findAll(PageRequest.of(page, size));
			
				model.addAttribute("pagesetbs", pagesetbs);
				int[] pages = new int[pagesetbs.getTotalPages()];
				model.addAttribute("pages",pages);
				model.addAttribute("size", size);
				model.addAttribute("page", page);
		
		return "listesetablissements";
	}
	@RequestMapping(value = "/deletee" , method = RequestMethod.GET)
	public String deletee(Long id) {
		etablissementRepository.deleteById(id);
		return "redirect:/listesetablissements";
	}
	@RequestMapping(value = "/edite" , method= RequestMethod.GET)
	public String edit(Model model , Long id ) {
		Etablissement m = etablissementRepository.getById(id);
		model.addAttribute("Etablissement", m);
		return "formMetier";
		
	}
	@RequestMapping(value = "/RechercherEtablissement")
	public String chercher(Model model  ,@RequestParam(name = "page", defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "20")int size, @RequestParam(name = "mc", defaultValue = "")String mc ) {
			
			Page<Etablissement> pagesetbs = etablissementRepository.chercherVille(mc,PageRequest.of(page, size));
		
			model.addAttribute("pagesetbs", pagesetbs);
			int[] pages = new int[pagesetbs.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("size", size);
			model.addAttribute("mc", mc);
			model.addAttribute("pagec", page);
		
		return "RechercherEtablissement";
	}

	@RequestMapping(value = "/saveetablissement", method = RequestMethod.GET)
	public String f(Model model) {
		model.addAttribute("etablissement", new Etablissement());
		model.addAttribute("villes", villeRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("universities", universityRepository.findAll());
		model.addAttribute("genrs", genreRepository.findAll());
		
		return "saveetablissement";
	}
	@RequestMapping(value = "/saveetablissement2", method = RequestMethod.POST)
	public String s(Model model , Etablissement etablissement) {
		etablissementRepository.save(etablissement);
		return "redirect:/listesetablissements";
	}
	@RequestMapping(value = "/searcheEcole")
	public String searcheEcole(Model model  ,@RequestParam(name = "page", defaultValue = "0")int page,
			@RequestParam(name = "size", defaultValue = "8")int size, @RequestParam(name = "mc", defaultValue = "")String mc ) {
			
			Page<Etablissement> pagesetbs = etablissementRepository.chercherVille(mc,PageRequest.of(page, size));
		
			model.addAttribute("pagesetbs", pagesetbs);
			int[] pages = new int[pagesetbs.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("size", size);
			model.addAttribute("mc", mc);
			model.addAttribute("pagec", page);
		
		
		return "searcheEcole";
	}

	@RequestMapping(value = "/EtablissementparBranches")
	public String getbranche(Model model,@RequestParam(value = "id") Long id) {
		  
		  String nomBranche = brancheRepository.findById(id).get().getNom_branche();
		  model.addAttribute("nomBranche",nomBranche);
		  model.addAttribute("etablissements", etablissementRepository.getEtablissementparbranche(id));
		  
		  return "EtablissementparBranches";
	  }
	
}
