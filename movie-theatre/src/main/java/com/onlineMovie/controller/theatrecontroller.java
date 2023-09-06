package com.onlineMovie.controller;

import com.onlineMovie.entity.theatre;
import com.onlineMovie.service.theatreservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatres")
public class theatrecontroller {
	@Autowired 
    private final theatreservice theatreservice;

    public theatrecontroller(theatreservice theatreservice) {
        this.theatreservice = theatreservice;
    }

    @GetMapping
    public List<theatre> getAllTheatres() {
        return theatreservice.getAllTheatres();
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<theatre> getTheatreById(@PathVariable Integer theatreId) {
        Optional<theatre> theatre = theatreservice.getTheatreById(theatreId);
        return theatre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/location/{location}")
    public List<theatre> getTheatresByLocation(@PathVariable String location) {
        return theatreservice.getTheatresByLocation(location);
    }

    @GetMapping("/movie/{movieId}")
    public List<theatre> getTheatresByMovieId(@PathVariable Integer movieId) {
        return theatreservice.getTheatresByMovieId(movieId);
    }

    @GetMapping("/location/{location}/movie/{movieId}")
    public List<theatre> getTheatresByLocationAndMovieId(@PathVariable String location, @PathVariable Integer movieId) {
        return theatreservice.getTheatresByLocationAndMovieId(location, movieId);
    }

    @PostMapping
    public ResponseEntity<theatre> createTheatre(@RequestBody theatre theatre) {
        theatre createdTheatre = theatreservice.createTheatre(theatre);
        return new ResponseEntity<>(createdTheatre, HttpStatus.CREATED);
    }

    @PutMapping("/{theatreId}")
    public ResponseEntity<theatre> updateTheatre(@PathVariable Integer theatreId, @RequestBody theatre updatedTheatre) {
        theatre updated = theatreservice.updateTheatre(theatreId, updatedTheatre);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{theatreId}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable Integer theatreId) {
        theatreservice.deleteTheatre(theatreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
