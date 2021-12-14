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

import com.example.immo.modeles.Terrain;
import com.example.immo.services.ServiceTerrain;

@RestController
@RequestMapping("/Terrains")
public class TerrainControleur {
	private final ServiceTerrain serviceTerrain;
	
	public TerrainControleur(ServiceTerrain serviceTerrain) {
		this.serviceTerrain = serviceTerrain;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Terrain>> getAllTerrains() {
		List<Terrain> terrains = serviceTerrain.getAllTerrains();
		return new ResponseEntity<List<Terrain>>(terrains, HttpStatus.OK);
		
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Terrain> chercherTerrainParId(@PathVariable("id") Long id) {
		Terrain terrain = serviceTerrain.trouverTerrainParId(id);
		return new ResponseEntity<Terrain>(terrain, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<Terrain> supprimerTerrainParId(@PathVariable("id") Long id) {
		serviceTerrain.supprimerTerrain(id);
		return new ResponseEntity<Terrain>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Terrain> ajouterUneTerrain(@RequestBody Terrain terrain) {
		Terrain newTerrain = serviceTerrain.ajouterTerrain(terrain);
		return new ResponseEntity<Terrain>(newTerrain, HttpStatus.CREATED);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<Terrain> mettreAJourUneTerrain(@RequestBody Terrain terrain) {
		Terrain updatedTerrain = serviceTerrain.ajouterTerrain(terrain);
		return new ResponseEntity<Terrain>(updatedTerrain, HttpStatus.OK);
	}
}


