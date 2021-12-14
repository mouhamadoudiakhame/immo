package com.example.immo.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Appartement extends BienImmobilier {
	@Column(nullable = false)
	private int nb_chambres;
}
