package com.example.immo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immo.modeles.Appartement;

public interface AppartementRepo extends JpaRepository<Appartement, Long>{

}
