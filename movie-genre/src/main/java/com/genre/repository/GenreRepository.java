package com.genre.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genre.entity.Genre;

@Repository(value="genreRepository")
public interface GenreRepository extends JpaRepository<Genre, Integer> {
	
	
}
