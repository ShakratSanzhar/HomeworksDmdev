package week4.homework2;

import java.util.*;

public class Cinema {

    private Map<Integer, List<Film>> mapOfFilms = new TreeMap<>();

    public Cinema(Map<Integer, List<Film>> mapOfFilms) {
        this.mapOfFilms = mapOfFilms;
    }

    public void addNewFilm(Film film) {
        if (!isHaveFilm(film)) {
            List<Film> listOfFilms = mapOfFilms.getOrDefault(film.getYearOfPublication(), new ArrayList<>());
            listOfFilms.add(film);
            mapOfFilms.put(film.getYearOfPublication(), (ArrayList<Film>) listOfFilms);
        }
    }

    public List<Film> getAllFilmsByYearOfPublication(int year) {
        return mapOfFilms.get(year);
    }

    public List<Film> getAllFilmsByYearAndMonthOfPublication(int year, MonthOfPublication month) {
        List<Film> listOfFilms = mapOfFilms.get(year);
        List<Film> listOfRequiredFilms = new ArrayList<>();
        for (Film film : listOfFilms) {
            if (film.getMonthOfPublication() == month) {
                listOfRequiredFilms.add(film);
            }
        }
        return listOfRequiredFilms;
    }

    public List<Film> getAllFilmsByGenre(Genre genre) {
        List<Film> listOfRequiredFilms = new ArrayList<>();
        for (List<Film> allFilms : mapOfFilms.values()) {
            for (Film film : allFilms) {
                if (film.getGenre() == genre) {
                    listOfRequiredFilms.add(film);
                }
            }
        }
        return listOfRequiredFilms;
    }

    public List<Film> getTopTenFilms() {
        List<Film> allFilms = new ArrayList<>();
        List<Film> requiredFilms = new ArrayList<>();
        for (List<Film> listOfFilms : mapOfFilms.values()) {
            allFilms.addAll(listOfFilms);
        }
        allFilms.sort(new FilmComparator().reversed());
        for (int i = 0; i < 10; i++) {
            requiredFilms.add(allFilms.get(i));
        }
        return requiredFilms;
    }

    private boolean isHaveFilm(Film newFilm) {
        boolean isHaveFilm = false;
        for (List<Film> allFilms : mapOfFilms.values()) {
            for (Film existingFilm : allFilms) {
                if (existingFilm.getId() == newFilm.getId()) {
                    isHaveFilm = true;
                    break;
                }
            }
            if (isHaveFilm) {
                break;
            }
        }
        return isHaveFilm;
    }
}


