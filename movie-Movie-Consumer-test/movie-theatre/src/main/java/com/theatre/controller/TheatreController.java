package com.theatre.controller;
//import java.sql.Date;
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

import com.theatre.entity.Theatre;
import com.theatre.service.TheatreService;

@RestController
@Scope(value = "request")
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	
	//private Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		//log.debug("Received a request to add a movie: " + movie);
		Theatre addedTheatre = theatreService.addTheatre(theatre);
		//log.info("Movie added: ", addedMOvie);
		return addedTheatre;
	}
	
	@PutMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Theatre updateMovie(@RequestBody Theatre theatre) {
		//log.debug("Received a request to update a movie: " + movie);
		Theatre updatedTheatre = theatreService.updateTheatre(theatre);
		//log.info("Movie updated: ", updatedMovie);
		return updatedTheatre;
	}
	
	@DeleteMapping(value = "/theatre/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTheatreById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to delete a movie with id: " + id);
		theatreService.deleteTheatreById(id);
		//log.info("Movie deleted with id: ", id);
	}
	
	@GetMapping(value = "/theatre/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Theatre getTheatreById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to get a movie with id: " + id);
		Theatre theatreById = theatreService.getTheatreById(id);
		//log.info("Return Value: ", movieById);
		return theatreById;
	}
	
	@GetMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Theatre> getAllTheatre() {
		//log.debug("Received a request to view all Movies");
		 List<Theatre> allTheatre = theatreService.getAllTheatre();
		 //log.info("All Movies Return Value: " + allMovie);
		 return allTheatre;
		
	}
	

}