package com.example.Orientation.entities;


import java.util.HashSet;
import java.util.Set;
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
public class Maladie {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long maladie_id;
	private String nom_maladie;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "maladie")
	@JsonIgnore
	private Set<Candidat> candidats = new HashSet<Candidat>(0);

	public Maladie() {
	}

	public Long getMaladie_id() {
		return maladie_id;
	}

	public void setMaladie_id(Long maladie_id) {
		this.maladie_id = maladie_id;
	}

	public String getNom_maladie() {
		return nom_maladie;
	}

	public void setNom_maladie(String nom_maladie) {
		this.nom_maladie = nom_maladie;
	}

	public Set<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(Set<Candidat> candidats) {
		this.candidats = candidats;
	}

	

}
