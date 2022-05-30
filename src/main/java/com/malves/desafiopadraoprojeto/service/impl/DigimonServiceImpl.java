package com.malves.desafiopadraoprojeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malves.desafiopadraoprojeto.model.Digimon;
import com.malves.desafiopadraoprojeto.repository.DigimonRepository;
import com.malves.desafiopadraoprojeto.service.DigimonService;

/**
 * 
 * @author michel
 *
 */
@Service
public class DigimonServiceImpl implements DigimonService {
	
	@Autowired
	private DigimonRepository digimonRepository;
	
	@Transactional(readOnly = true)
	@Override
	public ResponseEntity<List<Digimon>> buscarTodos() {
		List<Digimon> todos = digimonRepository.findAll();
		return ResponseEntity.ok(todos);
	}
	
	@Transactional(readOnly = true)
	@Override
	public ResponseEntity<Digimon> buscarPorNome(String name) {
		Optional<Digimon> digimonOptional = digimonRepository.findByName(name);
		if (digimonOptional.isPresent()) {
			Digimon digimon = digimonOptional.get();
			return ResponseEntity.ok(digimon);
		}
		return ResponseEntity.notFound().build();
	}

	@Transactional
	@Override
	public ResponseEntity<Digimon> inserir(Digimon digimon) {
		Digimon digimonInserido = digimonRepository.save(digimon);
		return ResponseEntity.ok( digimonInserido );
	}
	
	@Transactional
	@Override
	public ResponseEntity<Digimon> atualizar(Digimon digimon) {
		Optional<Digimon> digimonOptional = digimonRepository.findById(digimon.getId()); 
		if (digimonOptional.isPresent()) {
			return ResponseEntity.ok(digimonRepository.save(digimon));
		}
		return ResponseEntity.notFound().build();
	}

	@Transactional
	@Override
	public ResponseEntity<Void> deletar(Integer id) {
		Optional<Digimon> digimonOptional = digimonRepository.findById(id);
		if (digimonOptional.isPresent()) {
			digimonRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
