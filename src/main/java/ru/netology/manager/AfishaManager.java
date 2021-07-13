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

    public Movie[] getFeed() {
        int resultLength;
        int feedLength = repository.getFeedLength();
        Movie[] movies = repository.findAll();

        if (feedLength < movies.length) {
            resultLength = feedLength;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[i];
        }
        return result;
    }

    public int getFeedLength() {return repository.getFeedLength();}
    public void setFeedLength(int feedLength) {repository.setFeedLength(feedLength);}
}
