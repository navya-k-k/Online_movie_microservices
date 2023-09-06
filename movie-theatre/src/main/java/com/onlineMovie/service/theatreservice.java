package com.onlineMovie.service;

import com.onlineMovie.entity.theatre;
import com.onlineMovie.repository.theatrerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class theatreservice {
	 @Autowired
    private final theatrerepo theatreRepository;

   
    public theatreservice(theatrerepo theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Optional<theatre> getTheatreById(Integer theatreId) {
        return theatreRepository.findById(theatreId);
    }

    public List<theatre> getTheatresByLocation(String location) {
        return theatreRepository.findByTheatreLocation(location);
    }

    public List<theatre> getTheatresByMovieId(Integer movieId) {
        return theatreRepository.findByMovieId(movieId);
    }

    public List<theatre> getTheatresByLocationAndMovieId(String location, Integer movieId) {
        return theatreRepository.findByTheatreLocationAndMovieId(location, movieId);
    }

    public theatre createTheatre(theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public theatre updateTheatre(Integer theatreId, theatre updatedTheatre) {
        Optional<theatre> existingTheatreOptional = theatreRepository.findById(theatreId);

        if (existingTheatreOptional.isPresent()) {
            theatre existingTheatre = existingTheatreOptional.get();
            existingTheatre.setMovieId(updatedTheatre.getMovieId());
            existingTheatre.setTheatreLocation(updatedTheatre.getTheatreLocation());
            existingTheatre.setNoOfSeats(updatedTheatre.getNoOfSeats());
            existingTheatre.setTime(updatedTheatre.getTime());

            return theatreRepository.save(existingTheatre);
        } else {
            return null;
        }
    }

    public void deleteTheatre(Integer theatreId) {
        theatreRepository.deleteById(theatreId);
    }
}