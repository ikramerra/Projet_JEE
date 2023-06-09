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

/**
 * University generated by hbm2java
 */
@Entity
public class University implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long university_id;
	private String nom_university;
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
		@JsonIgnore
	private Set<Etablissement> etablissements = new HashSet<Etablissement>(0);

	public University() {
	}

	public Long getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(Long university_id) {
		this.university_id = university_id;
	}

	public String getNom_university() {
		return nom_university;
	}

	public void setNom_university(String nom_university) {
		this.nom_university = nom_university;
	}

	public Set<Etablissement> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(Set<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}

	

}
