package com.onlineMovie.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;

@Entity
public class theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TheatreId")
    private Integer theatreId;

    @Column(name = "MovieId")
    private Integer movieId;

    @Column(name = "TheatreLocation")
    private String theatreLocation;

    @Column(name = "NoOfSeats")
    private Integer noOfSeats;

    @Column(name = "Time")
    private Date time;
    public theatre() {
    }

    

	public theatre(Integer theatreId, Integer movieId, String theatreLocation, Integer noOfSeats, Date time) {
		super();
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.theatreLocation = theatreLocation;
		this.noOfSeats = noOfSeats;
		this.time = time;
	}



	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}