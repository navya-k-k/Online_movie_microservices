package com.language.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.language.entity.Language;

@Repository(value="languageRepository")
public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	
}
