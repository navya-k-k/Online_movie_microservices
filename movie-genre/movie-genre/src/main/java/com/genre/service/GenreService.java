package com.genre.service;

//import java.sql.Date;
import java.util.List;

import com.genre.entity.Genre;

public interface GenreService {
	
	public Genre addGenre(Genre genre);
	public Genre updateGenre(Genre genre);
	public List<Genre> getAllGenres ();
	public Genre getGenreById (Integer id);
	public void deleteGenreById (Integer id);
	
	
}
