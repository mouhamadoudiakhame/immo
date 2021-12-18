package com.example.immo.modeles;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private long id_personne;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;


	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
//	@OneToMany(mappedBy = "id_bien_immobilier")
//	private Set<BienImmobilier> bienImmobiliers;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = true)
	private int telephone;
	
	@Column(nullable = true)
	private String adresse;
	
	@Column(nullable = false)
	private String prenom;
	
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


	




	@Override
	public String toString() {
		return "Personne [id_personne=" + id_personne + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				 + ", prenom=" + prenom + ", nom=" + nom + ", telephone="
				+ telephone + ", adresse=" + adresse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_personne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return id_personne == other.id_personne;
	}

	public long getId_personne() {
		return id_personne;
	}

	public void setId_personne(long id_personne) {
		this.id_personne = id_personne;
	}

//	public Set<BienImmobilier> getBienImmobiliers() {
//		return bienImmobiliers;
//	}
//
//	public void setBienImmobiliers(Set<BienImmobilier> bienImmobiliers) {
//		this.bienImmobiliers = bienImmobiliers;
//	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	
	
}