package com.example.Orientation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Orientation.Dao.AdminRepository;

@Controller

public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;

	@RequestMapping(value = "/espaceadmin")
	public String espaceadmin() {
		
		
		return "espaceadmin";
	}

	@RequestMapping(value = "/teste")
	public String f(Model model, @RequestParam(name = "email")String email , @RequestParam("password")String password) {
		
		if((email.equalsIgnoreCase("admin")) && password.equals("admin"))
			return "espaceadmin";
		else
		
		return "index";
	}
	
}
