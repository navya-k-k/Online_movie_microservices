package com.language.controller;

//import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.language.entity.Language;
import com.language.service.LanguageService;

@RestController
@Scope(value = "request")
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	private Logger log = LoggerFactory.getLogger(LanguageController.class);
	
	@PostMapping(value = "/language", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Language addLanguage(@RequestBody Language language) {
		log.debug("Received a request to add a language: " + language);
		Language addedLanguage = languageService.addLanguage(language);
		log.info("Language added: ", addedLanguage);
		return addedLanguage;
	}
	
	@PutMapping(value = "/language/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Language updateLanguage(@PathVariable Integer id, @RequestBody Language language) {
	    Language updatedLanguage = languageService.updateLanguage(language, id);
	    if (updatedLanguage == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language with ID " + id + " not found");
	    }
	    
	    return updatedLanguage;
	}
	
	@DeleteMapping(value = "/language/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteLanguageById(@PathVariable("id") Integer id) {
		log.debug("Received a request to delete a language with id: " + id);
		languageService.deleteLanguageById(id);
		log.info("Language deleted with id: ", id);
	}
	
	@GetMapping(value = "/language/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Language getLanguageById(@PathVariable("id") Integer id) {
		log.debug("Received a request to get a language with id: " + id);
		Language languageById = languageService.getLanguageById(id);
		log.info("Return Value: ", languageById);
		return languageById;
	}
	
	@GetMapping(value = "/language", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Language> getAlllanguage() {
		log.debug("Received a request to view all Language");
		 List<Language> allLanguage = languageService.getAllLanguages();
		 log.info("All Language Return Value: " + allLanguage);
		 return allLanguage;
		
	}
	
	
}
