package com.generation.ufa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ufa.model.Tema;
import com.generation.ufa.repository.TemaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins ="*", allowedHeaders ="*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());	
	}
	
	@PostMapping
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema nome_tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(nome_tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putById(@Valid @RequestBody Tema nome_tema){
		return temaRepository.findById(nome_tema.getId())
				.map(resposta -> ResponseEntity.ok(temaRepository.save(nome_tema)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable Long id ){
		return temaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
		
	}
	

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> getById(@PathVariable String nome ){
		return ResponseEntity.ok(temaRepository.findAllByNomeContainingIgnoreCase(nome));
				
		
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Tema> tema = temaRepository.findById(id);
		
		if(tema.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		     
		        temaRepository.deleteById(id);
		
		
	}
	
	
}
