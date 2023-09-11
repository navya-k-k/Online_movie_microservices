package com.genre.entity;

//import java.sql.Date;

public class Genre {

	
	    private Integer genreId;
		private String name;
		public Integer getGenreId() {
			return genreId;
		}
		public void setGenreId(Integer genreId) {
			this.genreId = genreId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Genre(Integer genreId, String name) {
			super();
			this.genreId = genreId;
			this.name = name;
		}
		public Genre() {
			super();
		}
		
}

	

