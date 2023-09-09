package com.theatre.repository;

//import java.sql.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theatre.entity.Theatre;

@Repository(value="theatreRepository")
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	
}
