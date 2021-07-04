package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    public int feedLength = 10;

    public MovieManager() {
    }

    public MovieManager(int feedLength) {
        this.feedLength = feedLength;
    }

    public void addMovie(Movie movie) {
        // создаём новый массив размером на единицу больше
        int tmpLength = movies.length + 1;
        Movie[] tmp = new Movie[tmpLength];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < movies.length; i++) {
        //   tmp[i] = movies[i];
        // }
        System.arraycopy(movies, 0, tmp, 1, movies.length);
        // кладём первым наш элемент
        tmp[0] = movie;
        movies = tmp;
    }

    public Movie[] getFeed() {
        // TODO: add logic
        int resultLength;
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
}
