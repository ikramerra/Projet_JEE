package com.example.Orientation.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Filiere {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long filiere_id;
	private String libelle;
	
	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Candidat> candidats ;
	public Long getFiliere_id() {
		return filiere_id;
	}
	public void setFiliere_id(Long filiere_id) {
		this.filiere_id = filiere_id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Filiere() {
		
	}
	
	
	
	
}
