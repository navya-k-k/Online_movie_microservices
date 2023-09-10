package com.language.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.language.entity.Language;
import com.language.proxy.LanguageConsumerProxy;

@RestController
@Scope("request")
public class LanguageConsumerRestController {
	
	@Autowired
	private LanguageConsumerProxy languageconsumerproxy;
	
	private Logger log = LoggerFactory.getLogger(LanguageConsumerRestController.class);
	
	@GetMapping("/get-language/{id}")
	public Language getLanguageById(@PathVariable("id") int id) {
	    Language language = languageconsumerproxy.getLanguageById(id);
	    return language;
	}

	@GetMapping("/get-language")
	public List<Language> getAllLanguage() {
	
		List<Language> language = languageconsumerproxy.getAlllanguage();
		log.debug("In getAllLanguage with return value Language: " + language);
		return language;
		
	}
	
	@DeleteMapping("/delete-language/{id}")
	public void deleteLanguageById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete a Language with Id: " + id);
		languageconsumerproxy.deleteLanguageById(id);
	}
	
	@PostMapping("/add-language")
	public Language addLanguage(@RequestBody Language language) {
		log.debug("Request recieved to add an Employee: " + language);
		return languageconsumerproxy.addLanguage(language);
	}
	
	@PutMapping("/update-language/{id}")
	public Language updateLanguage(@PathVariable("id") Integer id, @RequestBody Language language) {
	    Language updatedLanguage = languageconsumerproxy.updateLanguage(language, id);
	    if (updatedLanguage == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Language with ID " + id + " not found");
	    }
	    return updatedLanguage;
	}
	
	
	
	
}
