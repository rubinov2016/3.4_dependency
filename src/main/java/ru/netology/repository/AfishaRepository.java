package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[]{};

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[movies.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie findById(String id) {
        Movie movie = new Movie();
        int index = 0;
        for (Movie item : movies) {
            if (id.equals(item.getId())) {
                movie = movies[index];
                index++;
            }
        }
        return movie;
    }

    public void removeById(String id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (!id.equals(item.getId())) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        movies = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        movies = tmp;
    }

}
