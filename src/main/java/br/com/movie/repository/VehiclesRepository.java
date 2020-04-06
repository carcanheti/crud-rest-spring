package br.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movie.model.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long>{

}
