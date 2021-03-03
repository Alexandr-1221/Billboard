package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.PurchaseFilm;

@Data
@NoArgsConstructor

public class FilmManager {
  private PurchaseFilm[] films = new PurchaseFilm[0];
  private int maxLength = 10;

  public FilmManager(int maxLength) {
    this.maxLength = maxLength;
  }

  public void add(PurchaseFilm film) {
    int length = films.length + 1;
    PurchaseFilm[] tmp = new PurchaseFilm[length];
    System.arraycopy(films, 0, tmp, 0, films.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = film;
    films = tmp;
  }

  public PurchaseFilm[] getAll() {
    int indexMax;
    indexMax = Math.min(maxLength, films.length);
    PurchaseFilm[] result = new PurchaseFilm[indexMax];
      for (int i = 0; i < indexMax; i++) {
        int index;
        index = films.length - i - 1;
        result[i] = films[index];
      }
      return result;
    }
  }
