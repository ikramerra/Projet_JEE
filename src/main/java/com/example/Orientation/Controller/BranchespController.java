package com.example.Orientation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Orientation.Dao.BranchespRepository;
import com.example.Orientation.entities.Branchesp;

@Controller

public class BranchespController {
	
	@Autowired
	BranchespRepository branchespRepository;
	
	@RequestMapping(value = "/brancheSup")
	public String brsep(Model model) {
		
		List<Branchesp>  branchesps = branchespRepository.findAll();
		model.addAttribute("branchesps", branchesps);
		
		return "";
	}
	

}
