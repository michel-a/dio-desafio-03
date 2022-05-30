package com.malves.desafiopadraoprojeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malves.desafiopadraoprojeto.model.Digimon;

/**
 * 
 * @author michel
 *
 */
@Repository
public interface DigimonRepository extends JpaRepository<Digimon, Integer> {

	Optional<Digimon> findByName(String nome);

}
