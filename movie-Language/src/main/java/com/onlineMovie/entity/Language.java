package com.onlineMovie.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;
    private String name;

    // Constructors
    public Language() {
        // Default constructor
    }

    public Language(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	

}