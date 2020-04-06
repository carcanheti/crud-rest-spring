package br.com.movie.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	
	private static final long serialVersionUID = 9047107825603196256L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
}
