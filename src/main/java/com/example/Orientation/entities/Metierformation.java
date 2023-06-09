package com.example.Orientation.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Metierformation generated by hbm2java
 */
@Entity
public class Metierformation {

	@EmbeddedId
	private MetierformationId id;
	@ManyToOne
	@MapsId("formation_id")
	@JsonIgnore
	private Formation formation;
	@ManyToOne
	@MapsId("metier_id")
	@JsonIgnore
	private Metier metier;

	public Metierformation() {
	}
	

	public MetierformationId getId() {
		return id;
	}

	public void setId(MetierformationId id) {
		this.id = id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	
	
}
