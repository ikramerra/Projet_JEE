package com.example.Orientation.entities;

import java.util.HashSet;
import java.util.Set;
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

@Entity
public class Ville  {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long ville_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;
	
	public String getNomville() {
		return nomville;
	}

	public void setNomville(String nomville) {
		this.nomville = nomville;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ville")
	@JsonIgnore
	private Set<Etablissement> etablissements = new HashSet<Etablissement>(0);
	
	private String nomville;
	public Ville() {
	}

	public Long getVille_id() {
		return ville_id;
	}

	public void setVille_id(Long ville_id) {
		this.ville_id = ville_id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<Etablissement> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(Set<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}


}
