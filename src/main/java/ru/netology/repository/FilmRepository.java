package ru.netology.repository;

import ru.netology.domain.PurchaseFilm;

public class FilmRepository {

    private PurchaseFilm[] films = new PurchaseFilm[0];

    public PurchaseFilm[] findAll() {
        return films;
    }

    public void save(PurchaseFilm newFilm) {
        int length = films.length + 1;
        PurchaseFilm[] result = new PurchaseFilm[length];
        System.arraycopy(films, 0, result, 0, films.length);
        result[result.length - 1] = newFilm;
        films = result;
    }

    public PurchaseFilm[] findById(int id) {
        PurchaseFilm[] result = new PurchaseFilm[1];
        for (PurchaseFilm film : films) {
            if (film.getId() == id) {
                result[0] = film;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        PurchaseFilm[] newFilm = new PurchaseFilm[length];
        int index = 0;
        for (PurchaseFilm film : films) {
            if (film.getId() != id) {
                newFilm[index] = film;
                index++;
            }
        }
        films = newFilm;
    }

    public void removeAll() {
        films = new PurchaseFilm[0];
    }
}
