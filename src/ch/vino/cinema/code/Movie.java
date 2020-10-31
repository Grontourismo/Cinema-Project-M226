package ch.vino.cinema.code;

import ch.vino.cinema.Main;
import org.json.simple.JSONObject;

public class Movie {
    private int idx;
    private String name;
    private int fsk;
    private double price;
    private String genre;
    private int length;

    /**
     * Initialize a new Movie
     *
     * @param name   Movie name
     * @param fsk    Movie FSK
     * @param price  Movie Price
     * @param genre  Movie Genre
     * @param length Movie play length
     * @param idx    Movie idx
     */
    public Movie(String name, int fsk, double price, String genre, int length, int idx) {
        this.name = name;
        this.fsk = fsk;
        this.price = price;
        this.genre = genre;
        this.length = length;
        this.idx = idx;
    }

    /**
     * create Movies from JSONObject
     *
     * @param jsonFilm Movie as JSONObject
     * @return new Movie
     */
    public static Movie fromJSON(JSONObject jsonFilm) {
        String filmname = (String) jsonFilm.get("filmname");
        int fsk = (int) (long) jsonFilm.get("fsk");
        float price = (float) (double) jsonFilm.get("price");
        String genre = (String) jsonFilm.get("genre");
        int lenght = (int) (long) jsonFilm.get("length");

        return new Movie(filmname, fsk, price, genre, lenght, Main.getCinema().getMovies().size());
    }

    /**
     * Get Movie description to show
     *
     * @return Movie description as formatted string
     */
    public String getFilmDescription() {
        return genre + " | " + fsk + " | " + length;
    }

    /**
     * Get the movie name
     *
     * @return movie name
     */
    public String getName() {
        return name;
    }

    /**
     * get movie fsk
     *
     * @return movie fsk
     */
    public int getFsk() {
        return fsk;
    }

    /**
     * get movie price
     *
     * @return movie price
     */
    public double getPrice() {
        return price;
    }

    /**
     * get movie genre
     *
     * @return movie genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * get movie idx
     *
     * @return movie idx
     */
    public int getIdx() {
        return idx;
    }

    /**
     * get movie length
     *
     * @return movie length
     */
    public int getLength() {
        return length;
    }
}