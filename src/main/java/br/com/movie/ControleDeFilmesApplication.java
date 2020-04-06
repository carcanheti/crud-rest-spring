package br.com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.movie")
public class ControleDeFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeFilmesApplication.class, args);
	}

}
