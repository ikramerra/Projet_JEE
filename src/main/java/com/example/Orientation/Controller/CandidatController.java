package com.example.Orientation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.Orientation.Dao.CandidatRepository;
import com.example.Orientation.Dao.FormationRepository;
import com.example.Orientation.Dao.MaladieRepository;
import com.example.Orientation.Dao.MetierRepository;
import com.example.Orientation.Dao.ProjetRepository;
import com.example.Orientation.Dao.RiasecRepository;
import com.example.Orientation.Service.CandidatService;
import com.example.Orientation.entities.Candidat;
import com.example.Orientation.entities.Maladie;
import com.example.Orientation.entities.Metier;
import com.example.Orientation.entities.Projet;
import com.example.Orientation.entities.Riasec;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class CandidatController {
	
	
	
	
	@Autowired
	CandidatRepository candidatRepository;
	
	@Autowired
	MaladieRepository maladieRepository;
	
	@Autowired
	MetierRepository metierRepository ;
	
	@Autowired
	RiasecRepository riasecRepository; 
	
	@Autowired
	FormationRepository formationRepository;
	@Autowired
	ProjetRepository projetRepository;
	
	@RequestMapping(value = "/inscrpcandidat", method = RequestMethod.GET)
	public String inscrpcandidat(Model model) {
		
		model.addAttribute("candidat", new Candidat());
		model.addAttribute("maladies", maladieRepository.findAll());
		model.addAttribute("riasecs", riasecRepository.findAll());
		
		return "inscrpcandidat";
	}
	
	@RequestMapping(value = "/login")
	
	public String login(Model model) {
		
		return "login";
	}

	  @RequestMapping(value = "/savecandidat", method = RequestMethod.POST)
	  public String s(Model model, Candidat candidat,@RequestParam("file") MultipartFile file) {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				candidat.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		  candidatRepository.save(candidat);
		  return "Confirmation";
	  }
	  
	  @RequestMapping(value = "/ind")
	  public String inf(Model model) {
		  
		  return "ind";
	  }
	  
	  @RequestMapping(value = "/monprofile")
	  public String getmet(Model model) {
//		 Candidat candidat = candidatRepository.getById(email);
//		  model.addAttribute("candidat", candidat);
		  
		  return "monprofile";
	  }
	  
	  
	  @RequestMapping(value = "/formationsParMetier")
	  public String getform(Model model , @RequestParam(value = "id") Long id) {
//		    Projet p = new Projet();
		   
		  String nomMetier = metierRepository.findById(id).get().getNmetier();
//		  Metier metier = metierRepository.getById(id);
//		  p.setMetier(metier);
//		  projetRepository.save(p);
		  model.addAttribute("nomMetier",nomMetier);
		  model.addAttribute("formations", formationRepository.getFomationsBymetier(id));
		  
		  return "formationsParMetier";
	  }
	  
	  @RequestMapping(value = "/Upload")
	  public String tets(Model model) {
//		 Candidat candidat = candidatRepository.getById(email);
//		  model.addAttribute("candidat", candidat);
		  
		  return "Upload";
	  }
	
	  
}
