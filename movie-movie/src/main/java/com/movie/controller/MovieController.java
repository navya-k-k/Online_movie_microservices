package com.movie.controller;

import java.sql.Date;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Movie;
import com.movie.service.MovieService;

@RestController
@Scope(value = "request")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	//private Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Movie addMovie(@RequestBody Movie movie) {
		//log.debug("Received a request to add a movie: " + movie);
		Movie addedMovie = movieService.addMovie(movie);
		//log.info("Movie added: ", addedMOvie);
		return addedMovie;
	}
	
	@PutMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Movie updateMovie(@RequestBody Movie movie) {
		//log.debug("Received a request to update a movie: " + movie);
		Movie updatedMovie = movieService.updateMovie(movie);
		//log.info("Movie updated: ", updatedMovie);
		return updatedMovie;
	}
	
	@DeleteMapping(value = "/movie/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMovieById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to delete a movie with id: " + id);
		movieService.deleteMovieById(id);
		//log.info("Movie deleted with id: ", id);
	}
	
	@GetMapping(value = "/movie/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Movie getMovieById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to get a movie with id: " + id);
		Movie movieById = movieService.getMovieById(id);
		//log.info("Return Value: ", movieById);
		return movieById;
	}
	
	@GetMapping(value = "/movie", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> getAllmovie() {
		//log.debug("Received a request to view all Movies");
		 List<Movie> allMovie = movieService.getAllMovies();
		 //log.info("All Movies Return Value: " + allMovie);
		 return allMovie;
		
	}
	@GetMapping(value = "/movie/genre/{genre}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByGenre(@PathVariable("genre") String genre) {
	    // log.debug("Received a request to find movies by genre: " + genre);
	    List<Movie> moviesByGenre = movieService.findByGenre(genre);
	    // log.info("Movies by genre: " + moviesByGenre);
	    return moviesByGenre;
	}

	@GetMapping(value = "/movie/language/{language}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByLanguage(@PathVariable("language") String language) {
	    // log.debug("Received a request to find movies by language: " + language);
	    List<Movie> moviesByLanguage = movieService.findByLanguage(language);
	    // log.info("Movies by language: " + moviesByLanguage);
	    return moviesByLanguage;
	}

	@GetMapping(value = "/movie/movie-time/{movieTime}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Movie> findByMovieTime(@PathVariable("movieTime") Date movieTime) {
	    // log.debug("Received a request to find movies by movie time: " + movieTime);
	    List<Movie> moviesByMovieTime = movieService.findByMovieTime(movieTime);
	    // log.info("Movies by movie time: " + moviesByMovieTime);
	    return moviesByMovieTime;
	}
	
}
