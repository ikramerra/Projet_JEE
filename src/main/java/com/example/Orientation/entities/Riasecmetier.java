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


@Entity
public class Riasecmetier{

@EmbeddedId
	private RiasecmetierId id;
	@ManyToOne
	@MapsId("metier_id")
	@JsonIgnore
	private Metier metier;
	@ManyToOne
	@MapsId("riasec_id")
	@JsonIgnore
	private Riasec riasec;

	public Riasecmetier() {
	}

	public RiasecmetierId getId() {
		return id;
	}

	public void setId(RiasecmetierId id) {
		this.id = id;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public Riasec getRiasec() {
		return riasec;
	}

	public void setRiasec(Riasec riasec) {
		this.riasec = riasec;
	}
	
	

}
