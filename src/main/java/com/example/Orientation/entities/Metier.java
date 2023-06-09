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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Metier generated by hbm2java
 */
@Entity
public class Metier {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long metier_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "secteur", nullable = false)
	private Secteur secteur;
	private String nmetier;
	private String definition;
	
	@OneToMany(mappedBy = "metier", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Projet> projets ;
	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metier")
	@JsonIgnore
	private Set<Riasecmetier> riasecmetiers = new HashSet<Riasecmetier>(0);
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "metier")
	@JsonIgnore
	private Set<Metierformation> metierformations = new HashSet<Metierformation>(0);

	public Metier() {
	}

	public Long getMetier_id() {
		return metier_id;
	}

	public void setMetier_id(Long metier_id) {
		this.metier_id = metier_id;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	

	public String getNmetier() {
		return nmetier;
	}

	public void setNmetier(String nmetier) {
		this.nmetier = nmetier;
	}

	public Set<Riasecmetier> getRiasecmetiers() {
		return riasecmetiers;
	}

	public void setRiasecmetiers(Set<Riasecmetier> riasecmetiers) {
		this.riasecmetiers = riasecmetiers;
	}

	public Set<Metierformation> getMetierformations() {
		return metierformations;
	}

	public void setMetierformations(Set<Metierformation> metierformations) {
		this.metierformations = metierformations;
	}

	
	

	}
