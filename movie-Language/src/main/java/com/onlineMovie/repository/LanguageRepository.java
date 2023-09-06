package com.onlineMovie.repository;

import com.onlineMovie.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    // You can add custom query methods here if needed{

}
