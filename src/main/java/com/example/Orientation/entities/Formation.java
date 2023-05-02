package com.example.Orientation.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Formation{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long formation_id;
	private String nom_formation;
	@OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Metierformation> metierformations = new HashSet<Metierformation>(0);
	
	@OneToMany(mappedBy = "formation", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Branche> branches ;

	public Formation() {
	}

	public Long getFormation_id() {
		return formation_id;
	}

	public void setFormation_id(Long formation_id) {
		this.formation_id = formation_id;
	}

	public String getNom_formation() {
		return nom_formation;
	}

	public void setNom_formation(String nom_formation) {
		this.nom_formation = nom_formation;
	}

	public Set<Metierformation> getMetierformations() {
		return metierformations;
	}

	public void setMetierformations(Set<Metierformation> metierformations) {
		this.metierformations = metierformations;
	}

	
	
}
