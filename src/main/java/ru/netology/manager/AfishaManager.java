package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        return  movies;
    }

    public Movie findById(String id) {
        Movie movie = repository.findById(id);
        return movie;
    }

    public void removeById(String id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
