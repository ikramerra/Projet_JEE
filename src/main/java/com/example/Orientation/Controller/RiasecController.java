package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Orientation.Dao.RiasecRepository;
import com.example.Orientation.entities.Riasec;
@Controller
public class RiasecController {
	
	@Autowired
	RiasecRepository riasecRepository;
	
//	@RequestMapping(value = "/riasecs" , method = RequestMethod.POST)
//	public String riasecs(Model model) {
//		
//		List<Riasec>  riasecs = riasecRepository.findAll();
//		model.addAttribute("riasecs", riasecs);
//		return "redirect:/inscription";
//		
//	}

	@GetMapping(value  = "/riasecs")
	public String maladies(Model model) {
		List<Riasec> riasecs =  riasecRepository.findAll();
		model.addAttribute("riasecs", riasecs);
		return "redirect:/get";
	}
	@PostMapping(path = "/riasecs")
	private String submitEmployee(@ModelAttribute("riasec") Riasec riasec, Model model) {
		model.addAttribute("da", riasec.toString());

		return "Confirmation";
	}
	
}
