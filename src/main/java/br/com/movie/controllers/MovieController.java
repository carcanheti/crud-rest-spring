package br.com.movie.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.movie.handlers.ResourceNotFoundException;
import br.com.movie.model.Register;
import br.com.movie.repository.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Register>> getAllRegister() {
		return ResponseEntity.status(HttpStatus.OK).body(movieRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Register> getRegisterById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {

		Register register = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Register not found for this id ::" + id));

		return ResponseEntity.ok().body(register);
	}

	@PostMapping
	public ResponseEntity<Register> createRegister(@Valid @RequestBody Register register) {
		register = movieRepository.save(register);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(register.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Register> updateRegister(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Register registerDetails) throws ResourceNotFoundException {

		Register register = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Register not found for this id ::" + id));

		register.setName(registerDetails.getName());
		register.setBirthYear(registerDetails.getBirthYear());
		register.setEyeColor(registerDetails.getEyeColor());
		register.setGender(registerDetails.getGender());
		register.setHairColor(registerDetails.getHairColor());
		register.setHeight(registerDetails.getHeight());
		register.setHomeworld(registerDetails.getHomeworld());

		movieRepository.save(register);

		return ResponseEntity.ok().body(register);
	}

	@DeleteMapping("/{id}")
	public String deleteRegister(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		Register register = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Register not found for this id ::" + id));

		movieRepository.delete(register);

		return "Delete by Register : " + id;
	}

}
