package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.PurchaseFilm;
import ru.netology.repository.FilmRepository;

@Data
@NoArgsConstructor

public class FilmManager {
  private FilmRepository repository;
  private int maxLength = 10;

  public FilmManager(FilmRepository repository) {
    this.repository = repository;
  }

  public FilmManager(int maxLength) {
    this.maxLength = maxLength;
  }

  public void add(PurchaseFilm film) {
    repository.save(film);
  }

  public PurchaseFilm[] getAll() {
    PurchaseFilm[] films = repository.findAll();
    int indexMax = Math.min(maxLength, films.length);
    PurchaseFilm[] result = new PurchaseFilm[indexMax];
    for (int i = 0; i < indexMax; i++) {
      int index = films.length - 1 - i;
      result[i] = films[index];
    }
    return result;
  }

  public PurchaseFilm[] getById(int id) {
    return repository.findById(id);
  }

  public void removeById(int id) {
    repository.removeById(id);
  }

  public void removeAll() {
    repository.removeAll();
  }
}
