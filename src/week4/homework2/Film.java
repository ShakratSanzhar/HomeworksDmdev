package week4.homework2;

public class Film {

    private int id;
    private int yearOfPublication;
    private MonthOfPublication monthOfPublication;
    private Genre genre;
    private double rating;

    public Film(int id, int yearOfPublication, MonthOfPublication monthOfPublication, Genre genre, double rating) {
        this.id = id;
        this.yearOfPublication = yearOfPublication;
        this.monthOfPublication = monthOfPublication;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public MonthOfPublication getMonthOfPublication() {
        return monthOfPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", yearOfPublication=" + yearOfPublication +
                ", monthOfPublication=" + monthOfPublication +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}
