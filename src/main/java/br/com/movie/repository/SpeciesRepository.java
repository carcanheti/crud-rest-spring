package br.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movie.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long>{

}
