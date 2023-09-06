package com.onlineMovie.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Genre {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long genreId;
	    private String name;

	    // Constructors, getters, and setters

	    public Genre() {
	        // Default constructor
	    }

	    public Genre(String name) {
	        this.name = name;
	    }

	    public Long getGenreId() {
	        return genreId;
	    }

	    public void setGenreId(Long genreId) {
	        this.genreId = genreId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return "Genre{" +
	                "genreId=" + genreId +
	                ", name='" + name + '\'' +
	                '}';
	    }
	}

