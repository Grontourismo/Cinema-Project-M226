package ch.vino.cinema.code;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Presentation {
    private Movie movie;
    private String date;
    private String time;
    private Room room;
    private ArrayList<String> seats;
    private int freePlaces;

    public Presentation(Movie movie, String date, String time, Room room) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.room = room;
        this.seats = room.getSeats();
        this.freePlaces = seats.size();
    }

    public void reserveSeats(HashSet<Integer> seatIDs) {
        for (int seatID : seatIDs) {
            seats.set(seatID, "XX");
            freePlaces--;
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }

    public int getFreePlaces() {
        return freePlaces;
    }
}