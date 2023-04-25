package com.generation.ufa.controller;

//import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ufa.model.Postagem;
import com.generation.ufa.repository.PostagemRepository;

import jakarta.validation.Valid;
//import jakarta.validation.constraints.PastOrPresent;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Postagem>post (@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	
	@PutMapping("/{id}") 
	public void put (@PathVariable Long id, @Valid @RequestBody Postagem postagem) {
		Optional <Postagem>post = postagemRepository.findById(id);
		if(post.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resposta -> {
					postagemRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
					
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem>getById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	
	/*@GetMapping("/{data}")
	public ResponseEntity <List<Postagem>> getByData (@PastOrPresent LocalDateTime data){
		return ResponseEntity.ok(postagemRepository.findAllByData(data));
	}*/
	
}
