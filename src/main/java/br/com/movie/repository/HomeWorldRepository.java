package br.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movie.model.HomeWorld;

@Repository
public interface HomeWorldRepository extends JpaRepository<HomeWorld, Long>{

}
