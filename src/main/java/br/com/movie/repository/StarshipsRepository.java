package br.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movie.model.Starships;

@Repository
public interface StarshipsRepository extends JpaRepository<Starships, Long>{

}
