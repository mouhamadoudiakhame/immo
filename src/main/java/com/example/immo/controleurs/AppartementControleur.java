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

import com.example.immo.modeles.Appartement;
import com.example.immo.services.ServiceAppartement;

@RestController
@RequestMapping("/Appartements")
public class AppartementControleur {
	private final ServiceAppartement serviceAppartement;
	
	public AppartementControleur(ServiceAppartement serviceAppartement) {
		this.serviceAppartement = serviceAppartement;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Appartement>> getAllAppartements() {
		List<Appartement> Appartements = serviceAppartement.getAllAppartements();
		return new ResponseEntity<List<Appartement>>(Appartements, HttpStatus.OK);
		
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Appartement> chercherAppartementParId(@PathVariable("id") Long id) {
		Appartement Appartement = serviceAppartement.trouverAppartementParId(id);
		return new ResponseEntity<Appartement>(Appartement, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<Appartement> supprimerAppartementParId(@PathVariable("id") Long id) {
		serviceAppartement.supprimerAppartement(id);
		return new ResponseEntity<Appartement>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Appartement> ajouterUneAppartement(@RequestBody Appartement Appartement) {
		Appartement newAppartement = serviceAppartement.ajouterAppartement(Appartement);
		return new ResponseEntity<Appartement>(newAppartement, HttpStatus.CREATED);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<Appartement> mettreAJourUneAppartement(@RequestBody Appartement Appartement) {
		Appartement updatedAppartement = serviceAppartement.ajouterAppartement(Appartement);
		return new ResponseEntity<Appartement>(updatedAppartement, HttpStatus.OK);
	}
}


