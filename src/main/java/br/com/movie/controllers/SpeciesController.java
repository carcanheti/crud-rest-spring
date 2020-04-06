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
import br.com.movie.model.Species;
import br.com.movie.repository.SpeciesRepository;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

	@Autowired
	private SpeciesRepository speciesRepository;

	@GetMapping("/all")
	public List<Species> getAllSpecies() {
		return speciesRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Species> getSpeciesById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {

		Species species = speciesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Species not found for this id ::" + id));

		return ResponseEntity.ok().body(species);
	}

	@PostMapping
	public Species createSpecies(@Valid @RequestBody Species species) {
		return speciesRepository.save(species);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Species> updateSpecies(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Species speciesDetails) throws ResourceNotFoundException {

		Species species = speciesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Species not found for this id ::" + id));

		species.setName(speciesDetails.getName());

		speciesRepository.save(species);

		return ResponseEntity.ok().body(species);
	}

	@DeleteMapping("/{id}")
	public String deleteSpecies(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		Species species = speciesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Species not found for this id ::" + id));

		speciesRepository.delete(species);

		return "Delete by species : " + id;
	}

}
