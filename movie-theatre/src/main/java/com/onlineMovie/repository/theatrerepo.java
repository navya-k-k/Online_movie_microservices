package com.onlineMovie.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlineMovie.entity.theatre;

@Repository(value="theatreRepository")
public interface theatrerepo extends JpaRepository<theatre, Integer>{
	List<theatre> findByTheatreLocation(String location);
    List<theatre> findByMovieId(Integer movieId);
    List<theatre> findByTheatreLocationAndMovieId(String location, Integer movieId);
	
}

