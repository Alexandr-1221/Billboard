package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseFilmTest {

    @Test
    public void validatePurchaseFilm(){
        PurchaseFilm film = new PurchaseFilm();
        film.setId(1);
        film.setFilmId(1);
        film.setFilmGenre("comedy");
        film.setFilmName("noname");
        assertEquals(1, film.getId());
        assertEquals(1, film.getFilmId());
        assertEquals("noname", film.getFilmName());
        assertEquals("comedy", film.getFilmGenre());
        assertFalse(film.isPremiere());
        film.setPremiere(true);
        assertTrue(film.isPremiere());
    }
}