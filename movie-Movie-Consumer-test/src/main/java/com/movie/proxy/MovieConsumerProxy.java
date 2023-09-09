package com.movie.proxy;


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

import com.movie.entity.Movie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-movie") // same as application name in movie-movie application.properties
public interface MovieConsumerProxy {

	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForGetMovieById")
	@GetMapping(value = "/movie/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Movie getMovieById(@PathVariable("id") Integer id);

	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForGetAllMovies")
	@GetMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> getAllmovie();
	
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForDeleteMovieById")
	@DeleteMapping(value = "/movie/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMovieById(@PathVariable("id") Integer id);
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Movie updateMovie(@RequestBody Movie movie);
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie addMovie(@RequestBody Movie movie);
	
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForGetByLanguage")
	@GetMapping(value = "/movie/language/{language}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByLanguage(@PathVariable("language") String language);
	
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForGetByDuration")
	@GetMapping(value = "/movie/movie-time/{movieTime}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByMovieTime(@PathVariable("movieTime") String duration);
	
	@Retry(name = "movie-consumer")
	@CircuitBreaker(name="movie-consumer", fallbackMethod="fallbackMethodForGetByGenre")
	@GetMapping(value = "/movie/genre/{genre}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByGenre(@PathVariable("genre") String genre);
	
    
    
	

	public default List<Movie> fallbackMethodForGetAllMovies(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Movie>();
	}
	
	public default Movie fallbackMethodForGetMovieById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		
		Movie fallbackMovie = new Movie(id, "Invalid name (Fall Back Movie)", "Invalid Description", "invalid Language",
				 "invalid Genre","0000", null, null,false, "000 minutes");
		return fallbackMovie;
	}
	
	public default void fallbackMethodForDeleteMovieById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Movie samplefallbackMethod(Movie movie, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		Movie fallbackMovie = new Movie(null, "Invalid name (Fall Back Movie)", "Invalid Description", "invalid Language",
				 "invalid Genre","0000", null, null,false, "000 minutes");
		return fallbackMovie;
	}
	
	public default List<Movie> fallbackMethodForGetByLanguage(String language, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Movie>();
	}
	
	public default List<Movie> fallbackMethodForGetByGenre(String genre, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Movie>();
		
	}
	public default List<Movie> fallbackMethodForGetByDuration(String duration, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Movie>();
	}
	
	

}
