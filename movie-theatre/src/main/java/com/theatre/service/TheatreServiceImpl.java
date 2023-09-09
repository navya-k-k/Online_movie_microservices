package com.theatre.service;

//import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.theatre.entity.Theatre;
import com.theatre.repository.TheatreRepository;

@Service
@Scope(value ="singleton")
public class TheatreServiceImpl implements TheatreService {
	
@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public Theatre addTheatre(Theatre theatre) {
		return theatreRepository.save(theatre);
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) {
		return theatreRepository.save(theatre);
	}

	@Override
	public List<Theatre> getAllTheatre() {
		return theatreRepository.findAll();
	}

	@Override
	public Theatre getTheatreById(Integer id) {
		return theatreRepository.findById(id).get();
	}

	@Override
	public void deleteTheatreById(Integer id) {
		theatreRepository.deleteById(id);
		
	}


	}

	


	
	


