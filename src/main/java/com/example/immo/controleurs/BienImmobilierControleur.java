package com.example.immo.controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.immo.modeles.BienImmobilier;
import com.example.immo.services.ServiceBienImmobilier;
import com.example.immo.services.ServiceBienImmobilier;

@RestController
@RequestMapping("/bien-immobiliers")
public class BienImmobilierControleur {
	private final ServiceBienImmobilier serviceBienImmobilier;
	
	public BienImmobilierControleur(ServiceBienImmobilier serviceBienImmobilier) {
		this.serviceBienImmobilier = serviceBienImmobilier;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BienImmobilier>> getAllBienImmobiliers() {
		List<BienImmobilier> bienImmobiliers = serviceBienImmobilier.getAllBienImmobiliers();
		return new ResponseEntity<List<BienImmobilier>>(bienImmobiliers, HttpStatus.OK);
		
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<BienImmobilier> chercherBienImmobilierParId(@PathVariable("id") Long id) {
		BienImmobilier bienImmobilier = serviceBienImmobilier.trouverBienImmobilierParId(id);
		return new ResponseEntity<BienImmobilier>(bienImmobilier, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<BienImmobilier> supprimerBienImmobilierParId(@PathVariable("id") Long id) {
		serviceBienImmobilier.supprimerBienImmobilier(id);
		return new ResponseEntity<BienImmobilier>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<BienImmobilier> ajouterUnBienImmobilier(@RequestBody BienImmobilier bienImmobilier) {
		BienImmobilier newBienImmobilier = serviceBienImmobilier.ajouterBienImmobilier(bienImmobilier);
		return new ResponseEntity<BienImmobilier>(newBienImmobilier, HttpStatus.CREATED);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<BienImmobilier> mettreAJourUnBienImmobilier(@RequestBody BienImmobilier bienImmobilier) {
		BienImmobilier updatedBienImmobilier = serviceBienImmobilier.ajouterBienImmobilier(bienImmobilier);
		return new ResponseEntity<BienImmobilier>(updatedBienImmobilier, HttpStatus.OK);
	}
}


