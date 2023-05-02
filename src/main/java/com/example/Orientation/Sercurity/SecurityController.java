package com.example.Orientation.Sercurity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/authenfication")
	public String autentificated(Model model ) {
		return "authenfication";
	}
	
	

}
