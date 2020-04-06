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
import br.com.movie.model.Vehicles;
import br.com.movie.repository.VehiclesRepository;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {

	@Autowired
	private VehiclesRepository vehiclesRepository;

	@GetMapping("/all")
	public List<Vehicles> getAllVehicles() {
		return vehiclesRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicles> getVehiclesById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {

		Vehicles vehicles = vehiclesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicles not found for this id ::" + id));

		return ResponseEntity.ok().body(vehicles);
	}

	@PostMapping
	public Vehicles createVehicles(@Valid @RequestBody Vehicles vehicles) {
		return vehiclesRepository.save(vehicles);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Vehicles> updateVehicles(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Vehicles vehiclesDetails) throws ResourceNotFoundException {

		Vehicles vehicles = vehiclesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicles not found for this id ::" + id));

		vehicles.setName(vehiclesDetails.getName());

		vehiclesRepository.save(vehicles);

		return ResponseEntity.ok().body(vehicles);
	}

	@DeleteMapping("/{id}")
	public String deleteVehicles(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

		Vehicles vehicles = vehiclesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicles not found for this id ::" + id));

		vehiclesRepository.delete(vehicles);

		return "Delete by Vehicles : " + id;
	}
}
