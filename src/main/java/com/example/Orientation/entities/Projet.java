package com.example.Orientation.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long projet_id;
	
	@ManyToOne
	@JoinColumn(name = "metier_id", nullable = true)
	private Metier metier;
	
	@ManyToOne
	@JoinColumn(name = "formation_id", nullable = true)
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name = "branche_id", nullable = true)
	private Branche branche;
	
	@ManyToOne
	@JoinColumn(name = "etablissement_id", nullable = true)
	private Etablissement etablissement;

	public Branche getBranche() {
		return branche;
	}

	public void setBranche(Branche branche) {
		this.branche = branche;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Long getProjet_id() {
		return projet_id;
	}

	public void setProjet_id(Long projet_id) {
		this.projet_id = projet_id;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}
	
	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Candidat> candidats ;
	
	
	
	
	
}
