package com.language.service;

//import java.sql.Date;
import java.util.List;

import com.language.entity.Language;

public interface LanguageService {
	
	public Language addLanguage(Language language);
	public Language updateLanguage(Language language);
	public List<Language> getAllLanguages ();
	public Language getLanguageById (Integer id);
	public void deleteLanguageById (Integer id);
	
	
}
