package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[]{};
    private int feedLength = 10;

    public int getFeedLength() {return this.feedLength;}
    public void setFeedLength(int feedLength) {this.feedLength = feedLength;}

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
        boolean isFound = false; //флаг, нашли ли мы значение
        int index = 0;
        for (Movie item : movies) {
            if (id.equals(item.getId())) {
                isFound = true;
            }else{
                    if (index < movies.length-1) {
                        tmp[index] = item;
                        index++;
                    }
                }
            }
            // меняем наши элементы
            if (isFound) {
                movies = tmp;
            } ;
        }

        public void removeAll () {
            Movie[] tmp = new Movie[0];
            movies = tmp;
        }

    }
