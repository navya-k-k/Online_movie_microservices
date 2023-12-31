package com.theatre.entity;

import java.sql.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 @Entity
@Table(name="theatre")
public class Theatre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TheatreId;
	private Integer MovieId;
	private String Theatrelocation;
	private Integer  NoOfSeats;
	private Date Time;
	public Integer getTheatreId() {
		return TheatreId;
	}
	public void setTheatreId(Integer theatreId) {
		TheatreId = theatreId;
	}
	public Integer getMovieId() {
		return MovieId;
	}
	public void setMovieId(Integer movieId) {
		MovieId = movieId;
	}
	public String getTheatrelocation() {
		return Theatrelocation;
	}
	public void setTheatrelocation(String theatrelocation) {
		Theatrelocation = theatrelocation;
	}
	public Integer getNoOfSeats() {
		return NoOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		NoOfSeats = noOfSeats;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public Theatre(Integer theatreId, Integer movieId, String theatrelocation, Integer noOfSeats, Date time) {
		super();
		TheatreId = theatreId;
		MovieId = movieId;
		Theatrelocation = theatrelocation;
		NoOfSeats = noOfSeats;
		Time = time;
	}
	public Theatre() {
		super();
	}
 }