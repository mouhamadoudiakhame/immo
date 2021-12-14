package com.example.immo.modeles;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BienImmobilier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	


	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", codeBienImmobilier=" + codeBienImmobilier + ", libelle=" + libelle
				+ ", description=" + description + ", adresse=" + adresse + ", imageUrl=" + imageUrl + ", surface="
				+ surface + ", prix=" + prix + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BienImmobilier other = (BienImmobilier) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeBienImmobilier() {
		return codeBienImmobilier;
	}

	public void setCodeBienImmobilier(String codeBienImmobilier) {
		this.codeBienImmobilier = codeBienImmobilier;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(nullable = false, updatable = false)
	private String codeBienImmobilier;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String adresse;
	
	@Column(nullable = true)
	private String imageUrl;
	
	@Column(nullable = true)
	private double surface;
	
	@Column(nullable = true)
	private double prix;
}
