package com.example.Orientation;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.Orientation.Dao.MetierRepository;
import com.example.Orientation.Dao.SecteurRepository;
import com.example.Orientation.entities.Metier;
import com.example.Orientation.entities.Secteur;

@SpringBootApplication
public class OrientationApplication {

	public static void main(String[] args) {
		ApplicationContext cntx =  SpringApplication.run(OrientationApplication.class, args);
		
	}

}
