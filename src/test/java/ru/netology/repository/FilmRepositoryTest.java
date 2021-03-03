package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseFilm;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    private FilmRepository repository = new FilmRepository();
    private PurchaseFilm first = new PurchaseFilm(1, 1, "first", "comedy", true);
    private PurchaseFilm second = new PurchaseFilm(2, 2, "second", "comedy", true);
    private PurchaseFilm third = new PurchaseFilm(3, 3, "third", "comedy", true);
    private PurchaseFilm fourth = new PurchaseFilm(4, 4, "fourth", "comedy", true);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void validateFindAll() {
        repository.save(fourth);
        PurchaseFilm[] actual = repository.findAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validateFindById() {
        PurchaseFilm[] actual = repository.findById(2);
        PurchaseFilm[] expected = new PurchaseFilm[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validateRemoveById() {
        repository.removeById(2);
        PurchaseFilm[] actual = repository.findAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validateRemoveAll() {
        repository.removeAll();
        PurchaseFilm[] actual = repository.findAll();
        PurchaseFilm[] expected = new PurchaseFilm[]{};
        assertArrayEquals(expected, actual);
    }
}