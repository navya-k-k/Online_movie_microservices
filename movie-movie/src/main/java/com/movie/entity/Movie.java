package com.movie.entity;

import java.sql.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
	
	private String movieName;
	private String description;
	private String language;
	private String genre;
	private String locationId;
	private Date movieTime;
	private Date releaseDate; 
	private boolean status;
	private String duration;
	
	
	
	
	
	public Movie() {
		super();
	}





	public Movie(Integer movieId, String movieName, String description, String language, String genre,
			String locationId, Date movieTime, Date releaseDate, boolean status, String duration) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
		this.language = language;
		this.genre = genre;
		this.locationId = locationId;
		this.movieTime = movieTime;
		this.releaseDate = releaseDate;
		this.status = status;
		this.duration = duration;
	}





	public Integer getMovieId() {
		return movieId;
	}





	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}





	public String getMovieName() {
		return movieName;
	}





	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getLanguage() {
		return language;
	}





	public void setLanguage(String language) {
		this.language = language;
	}





	public String getGenre() {
		return genre;
	}





	public void setGenre(String genre) {
		this.genre = genre;
	}





	public String getLocationId() {
		return locationId;
	}





	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}





	public Date getMovieTime() {
		return movieTime;
	}





	public void setMovieTime(Date movieTime) {
		this.movieTime = movieTime;
	}





	public Date getReleaseDate() {
		return releaseDate;
	}





	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}





	public boolean isStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}





	public String getDuration() {
		return duration;
	}





	public void setDuration(String duration) {
		this.duration = duration;
	}





	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", description=" + description + ", language="
				+ language + ", genre=" + genre + ", locationId=" + locationId + ", movieTime=" + movieTime
				+ ", releaseDate=" + releaseDate + ", status=" + status + ", duration=" + duration + "]";
	}
	
	
	
	
	
}
