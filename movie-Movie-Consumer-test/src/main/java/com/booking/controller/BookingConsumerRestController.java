package com.movie.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Movie;
import com.movie.proxy.MovieConsumerProxy;

@RestController
@Scope("request")
public class MovieConsumerRestController {
	
	@Autowired
	private MovieConsumerProxy movieconsumerproxy;
	
	//private Logger log = LoggerFactory.getLogger(MovieConsumerRestController.class);
	
	@GetMapping("/get-movie/{id}")
	public Movie getMovieById(@PathVariable("id") int id) {
	
		//log.debug("In getMovieById with Id: " + id);
		Movie movie = movieconsumerproxy.getMovieById(id);
		//log.debug("In getMovieById with return value Employee: " + movie);
		return movie;
	}

	@GetMapping("/get-movies")
	public List<Movie> getAllMovies() {
	
		List<Movie> movies = movieconsumerproxy.getAllmovie();
		//log.debug("In getAllMovies with return value Movies: " + movies);
		return movies;
		
	}
	
	@DeleteMapping("/delete-movie/{id}")
	public void deleteMovieById(@PathVariable("id") Integer id) {
		//log.debug("Request recieved to delete a Movie with Id: " + id);
		movieconsumerproxy.deleteMovieById(id);
	}
	
	@PostMapping("/add-movie")
	public Movie addMovie(@RequestBody Movie movie) {
		//log.debug("Request recieved to add an Employee: " + movie);
		return movieconsumerproxy.addMovie(movie);
	}
	
	@PutMapping("/update-movie")
	public Movie updateMovie(@RequestBody Movie movie) {
		//log.debug("Request recieved to update an Employee: " + movie);
		return movieconsumerproxy.updateMovie(movie);
	}
	
	
	
	@GetMapping("/get-language/{language}")
	public List<Movie> getMovieByLanguage(@PathVariable("language")String language) {
	
		//log.debug("In getMovieByLanguage with Language: " + language);
		List <Movie> movie = movieconsumerproxy.findByLanguage(language);
		
		//log.debug("In getMovieById with return value movie: " + movie);
		return movie;
	}
	
	@GetMapping("/get-genre/{genre}")
	public List<Movie> getMovieByGenre(@PathVariable("genre")String genre) {
	
		//log.debug("In getMovieByGenre with genre: " + genre);
		List <Movie> movie = movieconsumerproxy.findByGenre(genre);
		
		//log.debug("In getMovieByGenre with return value movie: " + movie);
		return movie;
	}
	
	@GetMapping("/get-time/{duration}")
	public List<Movie> getMovieByTime(@PathVariable("duration")String duration) {
	
		//log.debug("In getMovieByTime with Time: " + duration);
		List <Movie> movie = movieconsumerproxy.findByMovieTime(duration);
		
		//log.debug("In getMovieByTime with return value Movie: " + movie);
		return movie;
	}
	
	
	
	
	
}
