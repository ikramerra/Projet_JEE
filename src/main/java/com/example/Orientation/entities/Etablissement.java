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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
public class Etablissement{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long etablissement_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genre_id", nullable = false)
	private Genre genre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "university_id", nullable = false)
	private University university;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ville_id", nullable = false)
	private Ville ville;
	private String etablissement;
	@OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = Access.WRITE_ONLY)
	private Set<Brancheetablissement> brancheetablissements = new HashSet<Brancheetablissement>(0);
	private String etb_adresse;
	private String description;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String etb_tel;
	public String getEtb_tel() {
		return etb_tel;
	}

	public void setEtb_tel(String etb_tel) {
		this.etb_tel = etb_tel;
	}

	private String etb_site;
	private String etb_fax;
	
	public String getEtb_fax() {
		return etb_fax;
	}

	public void setEtb_fax(String etb_fax) {
		this.etb_fax = etb_fax;
	}

	public String getEtb_adresse() {
		return etb_adresse;
	}

	public void setEtb_adresse(String etb_adresse) {
		this.etb_adresse = etb_adresse;
	}

	

	public String getEtb_site() {
		return etb_site;
	}

	public void setEtb_site(String etb_site) {
		this.etb_site = etb_site;
	}

	public Etablissement() {
	}

	public Long getEtablissement_id() {
		return etablissement_id;
	}

	public void setEtablissement_id(Long etablissement_id) {
		this.etablissement_id = etablissement_id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Set<Brancheetablissement> getBrancheetablissements() {
		return brancheetablissements;
	}

	public void setBrancheetablissements(Set<Brancheetablissement> brancheetablissements) {
		this.brancheetablissements = brancheetablissements;
	}

	
	

}
