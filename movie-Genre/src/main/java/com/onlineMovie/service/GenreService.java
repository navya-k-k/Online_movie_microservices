package com.onlineMovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineMovie.entity.Genre;
import com.onlineMovie.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // Create
    public Genre createGenre(String name) {
        Genre genre = new Genre(name);
        return genreRepository.save(genre);
    }

    // Read
    public Genre getGenreById(Long id) {
        Optional<Genre> genreOptional = genreRepository.findById(id);
        return genreOptional.orElse(null);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Update
    public Genre updateGenre(Long id, String newName) {
        Optional<Genre> genreOptional = genreRepository.findById(id);
        if (genreOptional.isPresent()) {
            Genre genre = genreOptional.get();
            genre.setName(newName);
            return genreRepository.save(genre);
        }
        return null;
    }

    // Delete
    public boolean deleteGenre(Long id) {
        Optional<Genre> genreOptional = genreRepository.findById(id);
        if (genreOptional.isPresent()) {
            genreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}