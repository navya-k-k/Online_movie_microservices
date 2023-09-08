package com.movie.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;

@Service
@Scope(value ="singleton")
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public void deleteMovieById(Integer id) {
		movieRepository.deleteById(id);
		
	}

	@Override
	public List<Movie> findByGenre(String genre) {
	    return movieRepository.findByGenre(genre);
	}

	@Override
	public List<Movie> findByLanguage(String language) {
	    return movieRepository.findByLanguage(language);
	}

	@Override
	public List<Movie> findByMovieTime(Date movieTime) {
	    return movieRepository.findByMovieTime(movieTime);
	}

	


	
	

}
