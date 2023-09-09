package com.theatre.service;

//import java.sql.Date;
import java.util.List;

import com.theatre.entity.Theatre;

public interface TheatreService {
	
	public Theatre addTheatre(Theatre theatre);
	public Theatre updateTheatre(Theatre theatre);
	public List<Theatre> getAllTheatre ();
	public Theatre getTheatreById (Integer id);
	public void deleteTheatreById (Integer id);
	
}
