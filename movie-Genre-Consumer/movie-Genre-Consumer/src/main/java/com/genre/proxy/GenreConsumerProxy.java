package com.genre.proxy;


import java.util.ArrayList;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.genre.entity.Genre;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-genre") // same as application name in movie-movie application.properties
public interface GenreConsumerProxy {

	
	@Retry(name = "genre-consumer")
	@CircuitBreaker(name="genre-consumer", fallbackMethod="fallbackMethodForGetGenreById")
	@GetMapping(value = "/genre/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Genre getGenreById(@PathVariable("id") Integer id);

	@Retry(name = "genre-consumer")
	@CircuitBreaker(name="genre-consumer", fallbackMethod="fallbackMethodForGetAllGenre")
	@GetMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Genre> getAllgenre();
	
	
	@Retry(name = "genre-consumer")
	@CircuitBreaker(name="genre-consumer", fallbackMethod="fallbackMethodForDeleteGenreById")
	@DeleteMapping(value = "/genre/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteGenreById(@PathVariable("id") Integer id);
	
	@Retry(name = "genre-consumer")
	@CircuitBreaker(name="genre-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Genre updateGenre(@RequestBody Genre genre);
	
	@Retry(name = "genre-consumer")
	@CircuitBreaker(name="genre-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Genre addGenre(@RequestBody Genre genre);
	public default List<Genre> fallbackMethodForGetAllGenre(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Genre>();
	}
	
	public default Genre fallbackMethodForGetGenreById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Genre fallbackGenre = new Genre( id,"Invalid Genre");
			return fallbackGenre;
	}
	
	public default void fallbackMethodForDeleteGenreById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Genre samplefallbackMethod(Genre genre, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		Genre fallbackGenre = new Genre( null,"Invalid Genre");
		return fallbackGenre;
	}
	
	
	}