package code;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Cinema {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Presentation> presentations = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public void newRoom(String name, int rows, int seatsPerRow) {

    }

    public void newPresentation(Movie movie, Date date, Time time, Room room) {

    }

    public void newMovie(String name, int fsk, double price, String genre, int length) {

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}