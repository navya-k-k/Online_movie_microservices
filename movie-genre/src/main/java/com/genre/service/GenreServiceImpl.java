package com.genre.service;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.genre.entity.Genre;
import com.genre.repository.GenreRepository;

@Service
@Scope(value ="singleton")
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Genre addGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public Genre updateGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

	@Override
	public Genre getGenreById(Integer id) {
		return genreRepository.findById(id).get();
	}

	@Override
	public void deleteGenreById(Integer id) {
		genreRepository.deleteById(id);
		
	}

	

	


	
	

}
