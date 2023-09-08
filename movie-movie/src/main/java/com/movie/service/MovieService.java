package com.movie.service;

import java.sql.Date;
import java.util.List;

import com.movie.entity.Movie;

public interface MovieService {
	
	public Movie addMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public List<Movie> getAllMovies ();
	public Movie getMovieById (Integer id);
	public void deleteMovieById (Integer id);
	
	public List<Movie> findByGenre(String genre);
	public List<Movie> findByLanguage(String language);
	public List<Movie> findByMovieTime(Date movieTime);
}
