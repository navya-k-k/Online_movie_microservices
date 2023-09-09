package com.theatre.controller;

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
import com.theatre.entity.Theatre;
import com.theatre.proxy.TheatreConsumerProxy;

@RestController
@Scope("request")
public class TheatreConsumerRestController {
	
	@Autowired
	private TheatreConsumerProxy theatreconsumerproxy;
	
	//private Logger log = LoggerFactory.getLogger(MovieConsumerRestController.class);
	
	@GetMapping("/get-theatre/{id}")
	public Theatre getTheatreById(@PathVariable("id") int id) {
	
		//log.debug("In getMovieById with Id: " + id);
		Theatre theatre = theatreconsumerproxy.getTheatreById(id);
		//log.debug("In getMovieById with return value Employee: " + movie);
		return theatre;
	}

	@GetMapping("/get-theatre")
	public List<Theatre> getAllTheatre() {
	
		List<Theatre> theatre = theatreconsumerproxy.getAlltheatre();
		//log.debug("In getAllMovies with return value Movies: " + movies);
		return theatre;
		
	}
	
	@DeleteMapping("/delete-theatre/{id}")
	public void deleteTheatreById(@PathVariable("id") Integer id) {
		//log.debug("Request recieved to delete a Movie with Id: " + id);
		theatreconsumerproxy.deleteTheatreById(id);
	}
	
	@PostMapping("/add-theatre")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		//log.debug("Request recieved to add an Employee: " + movie);
		return theatreconsumerproxy.addTheatre(theatre);
	}
	
	@PutMapping("/update-theatre")
	public Theatre updateTheatre(@RequestBody Theatre theatre) {
		//log.debug("Request recieved to update an Employee: " + movie);
		return theatreconsumerproxy.updateTheatre(theatre);
	}
	
	
	
	
}
