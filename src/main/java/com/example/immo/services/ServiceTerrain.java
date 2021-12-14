package com.example.immo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immo.exceptions.MaisonNotFoundException;
import com.example.immo.exceptions.TerrainNotFoundException;
import com.example.immo.modeles.Maison;
import com.example.immo.modeles.Terrain;
import com.example.immo.repo.MaisonRepo;
import com.example.immo.repo.TerrainRepo;

@Service
@Transactional
public class ServiceTerrain {
private final TerrainRepo terrainRepo;
	
	@Autowired
	public ServiceTerrain(TerrainRepo terrainRepo) {
		this.terrainRepo = terrainRepo;
	}
	
	public Terrain ajouterTerrain(Terrain terrain) {
		return terrainRepo.save(terrain);
	}
	
	public List<Terrain> getAllTerrains() {
		return terrainRepo.findAll();
	}
	
	public void supprimerTerrain(Long id) {
		terrainRepo.deleteById(id);
	}
	
	public Terrain trouverTerrainParId(Long id) {
		return terrainRepo.findById(id)
				.orElseThrow(() -> new TerrainNotFoundException(("Terrain avec id " + id + " non trouve !!!")));
	}
}
