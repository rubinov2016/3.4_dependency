package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private Movie first = new Movie("first", "imageUrl1", "name1", "genre1");
    private Movie second = new Movie("second", "imageUrl2", "name2", "genre2");
    private Movie third = new Movie("third", "imageUrl3", "name3", "genre3");

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
        Movie[] expected = new Movie[]{third, second,first};

        assertArrayEquals(expected, actual);
    }

}
