package ch.vino.cinema.code;

import ch.vino.cinema.Main;
import org.json.simple.JSONObject;

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

    public Presentation(Movie movie, String date, String time, Room room, ArrayList<String> seats) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.room = room;
        this.seats = seats;
        this.freePlaces = seats.size();
        for (String seat : seats){
            if (seat.equals("XX")){
                freePlaces--;
            }
        }
    }

    public static Presentation fromJSON(JSONObject jsonPresentation) {
        Movie movie = Main.getCinema().getMovies().get((int) (long) jsonPresentation.get("film"));
        String date = (String) jsonPresentation.get("date");
        String  time = (String) jsonPresentation.get("time");
        Room  room = Main.getCinema().getRooms().get((int) (long) jsonPresentation.get("room"));
        ArrayList<String> roomSeats = (ArrayList<String>) jsonPresentation.get("roomSeats");

        return new Presentation(movie, date, time, room, roomSeats);
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