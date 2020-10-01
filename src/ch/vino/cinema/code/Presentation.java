package ch.vino.cinema.code;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

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
  
    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }

    public void reserveSeats(HashSet<Integer> seatIDs) {
        for (int seatID : seatIDs) {
            seats.set(seatID, "XX");
        }
    }
}