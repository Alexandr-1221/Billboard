package ru.netology.manager;

import lombok.Data;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseFilm;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Data

public class FilmManagerTest {
    private PurchaseFilm first = new PurchaseFilm(1, 1, "first", "comedy", true);
    private PurchaseFilm second = new PurchaseFilm(1, 1, "second", "comedy", true);
    private PurchaseFilm third = new PurchaseFilm(1, 1, "third", "comedy", true);
    private PurchaseFilm fourth = new PurchaseFilm(1, 1, "fourth", "comedy", true);
    private PurchaseFilm fifth = new PurchaseFilm(1, 1, "fifth", "comedy", true);
    private PurchaseFilm sixth = new PurchaseFilm(1, 1, "sixth", "comedy", true);
    private PurchaseFilm seventh = new PurchaseFilm(1, 1, "seventh", "comedy", true);
    private PurchaseFilm eighth = new PurchaseFilm(1, 1, "eighth", "comedy", true);
    private PurchaseFilm ninth = new PurchaseFilm(1, 1, "ninth", "comedy", true);
    private PurchaseFilm tenth = new PurchaseFilm(1, 1, "tenth", "comedy", true);
    private PurchaseFilm eleventh = new PurchaseFilm(1, 1, "eleventh", "comedy", true);

    @Test
    public void validateFilmManager(){
        FilmManager manager = new FilmManager();
        assertEquals(10, manager.getMaxLength());
    }

    @Test
    public void shouldAddFilm() {
        FilmManager manager = new FilmManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);

        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortedFilmsReverseUnderMax() {
        FilmManager manager = new FilmManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortedFilmsReverseOverMax() {
        FilmManager manager = new FilmManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortedFilmsReverseOverMaxEqualsFive() {
        FilmManager manager = new FilmManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        PurchaseFilm[] actual = manager.getAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{eleventh, tenth, ninth, eighth, seventh, null, null, null, null, null, null};

        assertArrayEquals(expected, actual);
    }

}