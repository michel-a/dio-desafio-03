package com.malves.desafiopadraoprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malves.desafiopadraoprojeto.model.Digimon;
import com.malves.desafiopadraoprojeto.service.DigimonService;

/**
 * 
 * @author michel
 *
 */
@RestController
@RequestMapping("/digimon")
public class DigimonRestController {

	@Autowired
	private DigimonService service;
	
	@GetMapping
	public ResponseEntity<List<Digimon>> buscarTodos() {
		return service.buscarTodos();
	}
		
	@GetMapping("/{name}")
	public ResponseEntity<Digimon> buscarPorNome(@PathVariable String name) {
		return service.buscarPorNome(name);
	}
	
	@PostMapping
	public ResponseEntity<Digimon> inserir(@RequestBody Digimon digimon) {
		return service.inserir(digimon);
	}
	
	@PutMapping
	public ResponseEntity<Digimon> atualizar(@RequestBody Digimon digimon) {
		return service.atualizar(digimon);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		return service.deletar(id);
	}
}
