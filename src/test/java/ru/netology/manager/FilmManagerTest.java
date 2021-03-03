package ru.netology.manager;

import lombok.Data;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseFilm;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.FilmManager;
import org.mockito.InjectMocks;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@Data

public class FilmManagerTest {
    @Mock
    private FilmRepository repository;
    @InjectMocks
    private FilmManager manager;
    private PurchaseFilm first = new PurchaseFilm(1, 1, "first", "comedy", true);
    private PurchaseFilm second = new PurchaseFilm(2, 2, "second", "comedy", true);
    private PurchaseFilm third = new PurchaseFilm(3, 3, "third", "comedy", true);
    private PurchaseFilm fourth = new PurchaseFilm(4, 4, "fourth", "comedy", true);
    private PurchaseFilm fifth = new PurchaseFilm(5, 5, "fifth", "comedy", true);
    private PurchaseFilm sixth = new PurchaseFilm(6, 6, "sixth", "comedy", true);
    private PurchaseFilm seventh = new PurchaseFilm(7, 7, "seventh", "comedy", true);
    private PurchaseFilm eighth = new PurchaseFilm(8, 8, "eighth", "comedy", true);
    private PurchaseFilm ninth = new PurchaseFilm(9, 9, "ninth", "comedy", true);
    private PurchaseFilm tenth = new PurchaseFilm(10, 10, "tenth", "comedy", true);
    private PurchaseFilm eleventh = new PurchaseFilm(11, 11, "eleventh", "comedy", true);

    @Test
    public void validateFilmManager(){
        FilmManager manager = new FilmManager();
        assertEquals(10, manager.getMaxLength());
    }

    @Test
    public void shouldSortedFilmsReverseUnderMax() {
        PurchaseFilm[] returned = new PurchaseFilm[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortedFilmsReverseOverMax() {
        PurchaseFilm[] returned = new PurchaseFilm[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}