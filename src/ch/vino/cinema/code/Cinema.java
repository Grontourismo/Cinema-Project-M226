package ch.vino.cinema.code;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public void newPresentation(int movie, String date, String time, int room){
        presentations.add(new Presentation(movies.get(movie), date, time, rooms.get(room)));
    }

    public void removePresentation(Presentation presentation){
        this.presentations.remove(presentation);
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
        Movie movie = new Movie("TESTER", 16, 15.0, "action", 146);
        this.movies.add(movie);
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        this.movies.add(new Movie("TEST", 16, 15.0, "action", 146));
        autoPresentation(movie);
    }

    public void autoPresentation(Movie movie){
        Room room = new Room("Saal", 5, 10);
        this.rooms.add(room);
        this.presentations.add(new Presentation(movie, "13.10.2020", "20.15", room));
        Room room1 = new Room("Saal1", 7, 10);
        this.rooms.add(room);
        this.presentations.add(new Presentation(movie, "13.10.2020", "20.15", room1));
        Room room2 = new Room("Saal2", 5, 15);
        this.rooms.add(room);
        this.presentations.add(new Presentation(movie, "13.10.2020", "20.15", room2));
        Room room3 = new Room("Saal3", 5, 11);
        this.rooms.add(room);
        this.presentations.add(new Presentation(movie, "13.10.2020", "20.15", room3));
    }
}