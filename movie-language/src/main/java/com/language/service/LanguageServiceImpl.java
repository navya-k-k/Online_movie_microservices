package com.language.service;

//import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.language.entity.Language;
import com.language.repository.LanguageRepository;

@Service
@Scope(value ="singleton")
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Language addLanguage(Language language) {
		return languageRepository.save(language);
	}

	@Override
	public Language updateLanguage(Language language, Integer id) {
	    Optional<Language> optionalLanguage = languageRepository.findById(id);
	    if (optionalLanguage.isPresent()) {
	        Language existingLanguage = optionalLanguage.get();
	        existingLanguage.setName(language.getName());
	        return languageRepository.save(existingLanguage);
	    } else {
	        throw new IllegalArgumentException("Language with ID " + id + " not found");
	    }
	}

	@Override
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	@Override
	public Language getLanguageById(Integer id) {
		return languageRepository.findById(id).get();
	}

	@Override
	public void deleteLanguageById(Integer id) {
		languageRepository.deleteById(id);
		
	}

	

	


	
	

}
