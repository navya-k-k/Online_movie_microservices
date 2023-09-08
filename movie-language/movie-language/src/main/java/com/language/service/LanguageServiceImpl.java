package com.language.service;

//import java.sql.Date;
import java.util.List;

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
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
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
