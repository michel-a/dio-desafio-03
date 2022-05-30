package com.malves.desafiopadraoprojeto.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.malves.desafiopadraoprojeto.model.Digimon;
/**
 * 
 * @author michel
 *
 */

public interface DigimonService {

	ResponseEntity<List<Digimon>> buscarTodos();

	ResponseEntity<Digimon> buscarPorNome(String name);
	
	ResponseEntity<Digimon> inserir(Digimon digimon);
	
	ResponseEntity<Digimon> atualizar(Digimon digimon);
	
	ResponseEntity<Void> deletar(Integer id);
}
