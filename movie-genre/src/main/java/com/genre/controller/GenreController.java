package com.genre.controller;

//import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.genre.entity.Genre;
import com.genre.service.GenreService;

@RestController
@Scope(value = "request")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	private Logger log = LoggerFactory.getLogger(GenreController.class);
	
	@PostMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Genre addGenre(@RequestBody Genre genre) {
		log.debug("Received a request to add a genre: " + genre);
		Genre addedGenre = genreService.addGenre(genre);
		log.info("Genre added: ", addedGenre);
		return addedGenre;
	}
	
	@PutMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Genre updateGenre(@RequestBody Genre genre) {
		log.debug("Received a request to update a genre: " + genre);
		Genre updatedGenre = genreService.updateGenre(genre);
		log.info("Genre updated: ", updatedGenre);
		return updatedGenre;
	}
	
	@DeleteMapping(value = "/genre/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteGenreById(@PathVariable("id") Integer id) {
		log.debug("Received a request to delete a genre with id: " + id);
		genreService.deleteGenreById(id);
		log.info("Genre deleted with id: ", id);
	}
	
	@GetMapping(value = "/genre/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Genre getGenreById(@PathVariable("id") Integer id) {
		log.debug("Received a request to get a genre with id: " + id);
		Genre genreById = genreService.getGenreById(id);
		//log.info("Return Value: ", genreById);
		return genreById;
	}
	
	@GetMapping(value = "/genre", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Genre> getAllgenre() {
		log.debug("Received a request to view all Genres");
		 List<Genre> allGenre = genreService.getAllGenres();
		log.info("All Genres Return Value: " + allGenre);
		 return allGenre;
		
	}
	
	
}
