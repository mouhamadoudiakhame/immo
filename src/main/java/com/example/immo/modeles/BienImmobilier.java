package com.example.immo.modeles;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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
	private long id_bien_immobilier;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;


	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(nullable = true)
	private String idPersonne = "non-renseigne";
	

	
	public String getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(String idPersonne) {
		this.idPersonne = idPersonne;
	}

	@Column(nullable = false)
	private String libelle;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String adresse;
	
	@Column(nullable = true)
	private String imageUrl = "https://www.maisons-pierre.com/wp-content/uploads/2020/08/Visuel5.jpg";
	
	@Column(nullable = true)
	private double surface;
	
	@Column(nullable = true)
	private double prix;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_personne")
	private Personne personne;
	

	@Override
	public int hashCode() {
		return Objects.hash(id_bien_immobilier);
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
		return id_bien_immobilier == other.id_bien_immobilier;
	}

	public long getId_bien_immobilier() {
		return id_bien_immobilier;
	}

	public void setId_bien_immobilier(long id_bien_immobilier) {
		this.id_bien_immobilier = id_bien_immobilier;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}
