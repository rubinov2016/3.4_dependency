package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    @Test
    public void shouldAddOne() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie("first", "url", "name", "genre");

        manager.addMovie(first);
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 30, 100})
    public void shouldAddThirty(int lengthAdd) { // только для случаев -> количество добавленных превышает длину Feed
        MovieManager manager = new MovieManager();
        int feedLength = manager.feedLength; //длина Feed
        int lengthRedundant = lengthAdd - feedLength;  //лишние фильмы
        Movie[] expected = new Movie[feedLength];
        for (int i = 0; i < lengthAdd; i++) {
            Movie movie = new Movie("id" + i, "url" + i, "name" + i, "genre" + i);
            manager.addMovie(movie);
            if (i > lengthRedundant - 1) {
                expected[lengthAdd - i - 1] = movie; //меняем порядок
            }
        }
        Movie[] actual = manager.getFeed();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldChangeFeedLength() {
        MovieManager manager = new MovieManager(5);
        Movie first = new Movie("first", "url", "name", "genre");
        Movie second = new Movie("second", "url", "name", "genre");
        Movie third = new Movie("third", "url", "name", "genre");
        Movie fourth = new Movie("fourth", "url", "name", "genre");
        Movie fifth = new Movie("fifth", "url", "name", "genre");
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
}
