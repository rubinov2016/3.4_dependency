package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
        @Test
        public void shouldMovie() {
            Movie actualMovie = new Movie();
            actualMovie.setId("first");
            actualMovie.setImageUrl("url");
            actualMovie.setName("name");
            actualMovie.setGenre("genre");

            assertEquals(actualMovie.getId(), "first"); //не смог сравнивать классы, так как просило overide Hash и тп
            assertEquals(actualMovie.getImageUrl(), "url");
            assertEquals(actualMovie.getName(), "name");
            assertEquals(actualMovie.getGenre(), "genre");
        }
}
