package com.onlineMovie.service;
import com.onlineMovie.entity.Language;
import com.onlineMovie.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService { 
	private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(Long languageId) {
        return languageRepository.findById(languageId);
    }

    public Language createLanguage(String name) {
        Language language = new Language(name);
        return languageRepository.save(language);
    }

    public Language updateLanguage(Long languageId, String newName) {
        Optional<Language> optionalLanguage = languageRepository.findById(languageId);
        if (optionalLanguage.isPresent()) {
            Language language = optionalLanguage.get();
            language.setName(newName);
            return languageRepository.save(language);
        } else {
            throw new RuntimeException("Language not found with id: " + languageId);
        }
    }

    public void deleteLanguage(Long languageId) {
        languageRepository.deleteById(languageId);
    }
}