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
	private Integer  NoOfColumn;
	private Integer  NoOfRows;
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
	public Integer getNoOfColumn() {
		return NoOfColumn;
	}
	public void setNoOfColumn(Integer noOfColumn) {
		NoOfColumn = noOfColumn;
	}
	public Integer getNoOfRows() {
		return NoOfRows;
	}
	public void setNoOfRows(Integer noOfRows) {
		NoOfRows = noOfRows;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public Theatre(Integer theatreId, Integer movieId, String theatrelocation, Integer noOfColumn, Integer noOfRows,
			Date time) {
		super();
		TheatreId = theatreId;
		MovieId = movieId;
		Theatrelocation = theatrelocation;
		NoOfColumn = noOfColumn;
		NoOfRows = noOfRows;
		Time = time;
	}
	@Override
	public String toString() {
		return "Theatre [TheatreId=" + TheatreId + ", MovieId=" + MovieId + ", Theatrelocation=" + Theatrelocation
				+ ", NoOfColumn=" + NoOfColumn + ", NoOfRows=" + NoOfRows + ", Time=" + Time + "]";
	} 
	
 }
	
	
	
	
	
	