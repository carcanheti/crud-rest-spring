package br.com.movie.controllers;

import java.util.List;

import javax.validation.Valid;

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

import br.com.movie.handlers.ResourceNotFoundException;
import br.com.movie.model.Starships;
import br.com.movie.repository.StarshipsRepository;

@RestController
@RequestMapping("/api/starships")
public class StarshipsController {

	@Autowired
	private StarshipsRepository starshipsRepository;

	@GetMapping("/all")
	public List<Starships> getAllStarships() {
		return starshipsRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Starships> getStarshipsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {

		Starships starships = starshipsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Starships not found for this id ::" + id));

		return ResponseEntity.ok().body(starships);
	}

	@PostMapping
	public Starships createStarships(@Valid @RequestBody Starships starships) {
		return starshipsRepository.save(starships);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Starships> updateStarships(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Starships starshipsDetails) throws ResourceNotFoundException {

		Starships starships = starshipsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Starships not found for this id ::" + id));

		starships.setName(starshipsDetails.getName());

		starshipsRepository.save(starships);

		return ResponseEntity.ok().body(starships);
	}

	@DeleteMapping("/{id}")
	public String deleteStarships(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		Starships starships = starshipsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Starships not found for this id ::" + id));

		starshipsRepository.delete(starships);

		return "Delete by Starships : " + id;
	}
	
}
