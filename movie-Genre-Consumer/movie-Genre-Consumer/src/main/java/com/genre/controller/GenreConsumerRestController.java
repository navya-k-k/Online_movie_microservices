package com.genre.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genre.entity.Genre;
import com.genre.proxy.GenreConsumerProxy;

@RestController
@Scope("request")
public class GenreConsumerRestController {
	
	@Autowired
	private GenreConsumerProxy genreconsumerproxy;
	
	private Logger log = LoggerFactory.getLogger(GenreConsumerRestController.class);
	
	@GetMapping("/get-genre/{id}")
	public Genre getGenreById(@PathVariable("id") int id) {
	
		log.debug("In getGenreById with Id: " + id);
		Genre genre = genreconsumerproxy.getGenreById(id);
		log.debug("In getGenreById with return value Employee: " + genre);
		return genre;
	}

	@GetMapping("/get-genre")
	public List<Genre> getAllGenre() {
	
		List<Genre> genre = genreconsumerproxy.getAllgenre();
		log.debug("In getAllGenres with return value Genres: " + genre);
		return genre;
		
	}
	
	@DeleteMapping("/delete-genre/{id}")
	public void deleteGenreById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete a Genre with Id: " + id);
		genreconsumerproxy.deleteGenreById(id);
	}
	
	@PostMapping("/add-genre")
	public Genre addGenre(@RequestBody Genre genre) {
		log.debug("Request recieved to add an Employee: " + genre);
		return genreconsumerproxy.addGenre(genre);
	}
	
	@PutMapping("/update-genre")
	public Genre updateGenre(@RequestBody Genre genre) {
		log.debug("Request recieved to update an Employee: " + genre);
		return genreconsumerproxy.updateGenre(genre);
	}
	
}