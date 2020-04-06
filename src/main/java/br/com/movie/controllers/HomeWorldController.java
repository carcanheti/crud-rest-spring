package br.com.movie.controllers;

import java.util.List;
import java.util.Optional;

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
import br.com.movie.model.HomeWorld;
import br.com.movie.repository.HomeWorldRepository;

@RestController
@RequestMapping("/api/planets")
public class HomeWorldController {

	@Autowired
	private HomeWorldRepository homeWorldRepository;

	@GetMapping("/all")
	public List<HomeWorld> getAllHomeWorl() {
		return homeWorldRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<HomeWorld> getHomeWorldById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {

		HomeWorld homeWorld = homeWorldRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Home World not found for this id ::" + id));

		return ResponseEntity.ok().body(homeWorld);
	}

	@PostMapping
	public HomeWorld createHomeWorld(@Valid @RequestBody HomeWorld homeWorld) {
		return homeWorldRepository.save(homeWorld);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HomeWorld> updateHomeWorl(@PathVariable(value = "id") Long id,
			@Valid @RequestBody HomeWorld homeWorldDetails) throws ResourceNotFoundException {

		HomeWorld homeWorld = homeWorldRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Home World not found for this id ::" + id));

		homeWorld.setName(homeWorldDetails.getName());

		homeWorldRepository.save(homeWorld);

		return ResponseEntity.ok().body(homeWorld);
	}

	@DeleteMapping("/{id}")
	public String deleteHomeWorld(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		HomeWorld homeWorld = homeWorldRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Home World not found for this id ::" + id));

		homeWorldRepository.delete(homeWorld);

		return "Delete by Home World : " + id;
	}

}
