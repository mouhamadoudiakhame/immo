package com.example.immo.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Appartement extends BienImmobilier {
	@Column(nullable = false)
	private int nb_chambres;

	public int getNb_chambres() {
		return nb_chambres;
	}

	public void setNb_chambres(int nb_chambres) {
		this.nb_chambres = nb_chambres;
	}
}
