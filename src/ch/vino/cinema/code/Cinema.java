package ch.vino.cinema.code;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Cinema {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Presentation> presentations = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();

    public void newRoom(String name, int rows, int seatsPerRow){
        rooms.add(new Room(name, rows, seatsPerRow));
    }

    public void removeRoom(Room room){
        for (Presentation presentation : getPresentationsWithRoom(room)){
            this.presentations.remove(presentation);
        }
        this.rooms.remove(room);
    }

    public void newPresentation(int movie, Date date, Time time, int room){
        presentations.add(new Presentation(movies.get(movie), date, time, rooms.get(room)));
    }

    public void newMovie(String name, int fsk, double price, String genre, int length){
        movies.add(new Movie(name, fsk, price, genre, length));
    }

    public void removeMovie(Movie movie){
        for (Presentation presentation : getPresentationsFromMovie(movie)){
            this.presentations.remove(presentation);
        }
        this.movies.remove(movie);
    }

    public ArrayList<Presentation> getPresentationsFromMovie(Movie movie){
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if (presentation.getMovie() == movie){
                presentations.add(presentation);
            }
        }
        return presentations;
    }

    public ArrayList<Presentation> getPresentationsWithRoom(Room room){
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if (presentation.getRoom() == room){
                presentations.add(presentation);
            }
        }
        return presentations;
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

    public void autoMovies(){
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
    }
}