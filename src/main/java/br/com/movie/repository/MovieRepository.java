package br.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movie.model.Register;

@Repository
public interface MovieRepository extends JpaRepository<Register, Long>{

}
