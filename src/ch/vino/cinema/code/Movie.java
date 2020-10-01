package ch.vino.cinema.code;

public class Movie {
    private String name;
    private int fsk;
    double price;
    String genre;
    int length;

    public Movie(String name, int fsk, double price, String genre, int length) {
        this.name = name;
        this.fsk = fsk;
        this.price = price;
        this.genre = genre;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getFsk() {
        return fsk;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }
}