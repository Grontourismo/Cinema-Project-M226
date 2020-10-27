package ch.vino.cinema.code;

import ch.vino.cinema.Main;
import org.json.simple.JSONObject;

public class Movie {
    private int idx;
    private String name;
    private int fsk;
    double price;
    String genre;
    int length;

    public Movie(String name, int fsk, double price, String genre, int length, int idx) {
        this.name = name;
        this.fsk = fsk;
        this.price = price;
        this.genre = genre;
        this.length = length;
        this.idx = idx;
    }

    public static Movie fromJSON(JSONObject jsonFilm) {
        String filmname = (String) jsonFilm.get("filmname");
        int fsk = (int) (long) jsonFilm.get("fsk");
        float price = (float) (double) jsonFilm.get("price");
        String  genre = (String) jsonFilm.get("genre");
        int lenght = (int) (long) jsonFilm.get("length");

        return new Movie(filmname, fsk, price, genre, lenght, Main.getCinema().getMovies().size());
    }

    public String getFilmDescription(){
        return genre + " | " + fsk + " | " + length;
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

    public int getIdx() {
        return idx;
    }

    public int getLength() {
        return length;
    }
}