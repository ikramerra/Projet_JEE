package com.example.Orientation.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RiasecmetierId implements java.io.Serializable {

@Column
	private Long metier;
	@Column
	private Long riasec;

	public RiasecmetierId() {
	}


}
