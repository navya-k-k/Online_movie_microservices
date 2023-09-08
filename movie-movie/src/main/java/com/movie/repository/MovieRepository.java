package com.movie.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;

@Repository(value="movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findByGenre(String genre);
	List<Movie> findByLanguage(String language);
	List<Movie> findByMovieTime(Date movieTime);
}
