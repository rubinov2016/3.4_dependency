package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    //   private AfishaRepository repository;
    private AfishaManager manager;
    private Movie first = new Movie("first", "imageUrl1", "name1", "genre1");
    private Movie second = new Movie("second", "imageUrl2", "name2", "genre2");
    private Movie third = new Movie("third", "imageUrl3", "name3", "genre3");

    @Test
    public void shouldFindByID() {
        String id = "first";

        Movie returned = first;
        doReturn(returned).when(repository).findById(id);

        Movie expected = first;
        Movie actual = manager.findById(id);
        assertEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка "внутренней" реализации
        verify(repository).findById(id);

    }

    @Test
    public void shouldRemoveIfExists() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        String idToRemove = "first";
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfNotExists() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        String idToRemove = "fourth";
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.removeAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOne() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);

        manager.add(first);
        Movie[] actual = manager.getFeed();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 30, 100})
    public void shouldAddThirty(int lengthAdd) { // только для случаев -> количество добавленных превышает длину Feed
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);
        int feedLength = manager.getFeedLength(); //длина Feed
        int lengthRedundant = lengthAdd - feedLength;  //лишние фильмы
        Movie[] expected = new Movie[feedLength];
        for (int i = 0; i < lengthAdd; i++) {
            Movie movie = new Movie("id" + i, "url" + i, "name" + i, "genre" + i);
            manager.add(movie);
            if (i > lengthRedundant - 1) {
                expected[lengthAdd - i - 1] = movie; //меняем порядок
            }
        }
        Movie[] actual = manager.getFeed();
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldFindByID() {
//        AfishaRepository repository = new AfishaRepository();
//        AfishaManager manager = new AfishaManager(repository);
//        manager.add(first);
//        manager.add(second);
//        manager.add(third);
//
//        Movie[] actual = {manager.findById("first")};
//        Movie[] expected = {first};
//
//        assertArrayEquals(expected, actual);
//    }

}
