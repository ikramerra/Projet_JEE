package com.example.Orientation.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BrancheetablissementId generated by hbm2java
 */
@Embeddable
public class BrancheetablissementId implements java.io.Serializable {

	@Column
	private Long branche_id;
	@Column
	private Long etablissement_id;

	public BrancheetablissementId() {
	}

}
