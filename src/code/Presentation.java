package code;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Presentation {
    Movie movie;
    Date date;
    Time time;
    Room room;
    private ArrayList<String> seats = new ArrayList<>();

    public Presentation(Movie movie, Date date, Time time, Room room) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.room = room;
        this.seats = room.getSeats();
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }
}
