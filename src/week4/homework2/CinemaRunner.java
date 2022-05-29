package week4.homework2;

import java.util.*;

public class CinemaRunner {

    public static void main(String[] args) {
        Film film1 = new Film(1, 2002, MonthOfPublication.FEBRUARY, Genre.ACTION, 5.5);
        Film film2 = new Film(2, 2005, MonthOfPublication.JANUARY, Genre.DRAMA, 6.2);
        Film film3 = new Film(3, 2010, MonthOfPublication.MAY, Genre.COMEDY, 9.0);
        Film film4 = new Film(4, 2002, MonthOfPublication.MARCH, Genre.THRILLER, 5.1);
        Film film5 = new Film(5, 2013, MonthOfPublication.OCTOBER, Genre.ACTION, 4.6);
        Film film6 = new Film(6, 2005, MonthOfPublication.DECEMBER, Genre.THRILLER, 8.5);
        Film film7 = new Film(7, 2013, MonthOfPublication.OCTOBER, Genre.COMEDY, 7.2);
        Film film8 = new Film(8, 2005, MonthOfPublication.FEBRUARY, Genre.DRAMA, 9.1);
        Film film9 = new Film(9, 2011, MonthOfPublication.APRIL, Genre.ACTION, 5.8);
        Film film10 = new Film(10, 2010, MonthOfPublication.MAY, Genre.COMEDY, 7.4);
        Film film11 = new Film(11, 2002, MonthOfPublication.FEBRUARY, Genre.DRAMA, 7.2);
        Film film12 = new Film(12, 2011, MonthOfPublication.NOVEMBER, Genre.THRILLER, 9.0);
        List<Film> listOfFilms2002 = new ArrayList<>(Arrays.asList(film1, film4, film11));
        List<Film> listOfFilms2005 = new ArrayList<>(Arrays.asList(film2, film6, film8));
        List<Film> listOfFilms2010 = new ArrayList<>(Arrays.asList(film3, film10));
        List<Film> listOfFilms2011 = new ArrayList<>(Arrays.asList(film9, film12));
        List<Film> listOfFilms2013 = new ArrayList<>(Arrays.asList(film5, film7));
        Map<Integer, List<Film>> map = new TreeMap<>();
        map.put(2002, listOfFilms2002);
        map.put(2005, listOfFilms2005);
        map.put(2010, listOfFilms2010);
        map.put(2011, listOfFilms2011);
        map.put(2013, listOfFilms2013);
        Cinema cinema = new Cinema(map);
        Film film13 = new Film(13, 2005, MonthOfPublication.DECEMBER, Genre.THRILLER, 10.2);
        cinema.addNewFilm(film13);
        printFilms(cinema.getTopTenFilms());
        printFilms(cinema.getAllFilmsByYearOfPublication(2005));
        printFilms(cinema.getAllFilmsByYearAndMonthOfPublication(2002, MonthOfPublication.FEBRUARY));
        printFilms(cinema.getAllFilmsByGenre(Genre.THRILLER));
    }

    private static void printFilms(List<Film> films) {
        for (Film film : films) {
            System.out.println(film);
        }
    }
}
