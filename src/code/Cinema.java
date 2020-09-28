package code;

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

    public void newPresentation(int movie, Date date, Time time, int room){
        presentations.add(new Presentation(movies.get(movie), date, time, rooms.get(room)));
    }

    public void newMovie(String name, int fsk, double price, String genre, int length){
        movies.add(new Movie(name, fsk, price, genre, length));
    }


    public ArrayList<Presentation> getPresentationsFromMovie(int movieIdx){
        Movie movie = movies.get(movieIdx);
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if (presentation.getMovie() == movie){
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
}
