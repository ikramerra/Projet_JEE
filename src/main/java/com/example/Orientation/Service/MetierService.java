package com.example.Orientation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Orientation.Dao.MetierRepository;
import com.example.Orientation.entities.Metier;

@RestController

public class MetierService {
	
	@Autowired
	private MetierRepository metierRepository;
	
	
	

}
