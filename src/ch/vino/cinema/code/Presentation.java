package ch.vino.cinema.code;

import ch.vino.cinema.Main;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

public class Presentation {
    private Movie movie;
    private String date;
    private String time;
    private Room room;
    private ArrayList<String> seats;
    private int freePlaces;

    /**
     * Initialize a new Presentation
     *
     * @param movie Movie which should have a new presentation
     * @param date  date of the presentation
     * @param time  when the presentation starts
     * @param room  room in which the presentation will start
     */
    public Presentation(Movie movie, String date, String time, Room room) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.room = room;
        this.seats = room.getSeats();
        this.freePlaces = seats.size();
    }

    /**
     * Initialize a Presentation with reserved seats
     *
     * @param movie movie with presentation
     * @param date  date of the presentation
     * @param time  time when the presentation starts
     * @param room  room in which the presentation will start
     * @param seats seats in the room
     */
    public Presentation(Movie movie, String date, String time, Room room, ArrayList<String> seats) {
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.room = room;
        this.seats = seats;
        this.freePlaces = seats.size();
        for (String seat : seats) {
            if (seat.equals("XX")) {
                freePlaces--;
            }
        }
    }

    /**
     * create Presentations from json
     *
     * @param jsonPresentation JSONObject of the presentations
     * @return new presentation
     */
    public static Presentation fromJSON(JSONObject jsonPresentation) {
        Movie movie = Main.getCinema().getMovies().get((int) (long) jsonPresentation.get("film"));
        String date = (String) jsonPresentation.get("date");
        String time = (String) jsonPresentation.get("time");
        Room room = Main.getCinema().getRooms().get((int) (long) jsonPresentation.get("room"));
        ArrayList<String> roomSeats = (ArrayList<String>) jsonPresentation.get("roomSeats");

        return new Presentation(movie, date, time, room, roomSeats);
    }

    /**
     * reserve chosen seats
     *
     * @param seatIDs seat ids which were chosen
     */
    public void reserveSeats(HashSet<Integer> seatIDs) {
        for (int seatID : seatIDs) {
            seats.set(seatID, "XX");
            freePlaces--;
        }
    }

    /**
     * get Movie from the presentation
     *
     * @return movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * get Date from the presentation
     *
     * @return date as string
     */
    public String getDate() {
        return date;
    }

    /**
     * get Time from the presentation
     *
     * @return time as string
     */
    public String getTime() {
        return time;
    }

    /**
     * get the room in which the presentatin is
     *
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * get seats in the presentation
     *
     * @return seats as arraylist
     */
    public ArrayList<String> getSeats() {
        return seats;
    }

    /**
     * get number of free places
     *
     * @return number of free places
     */
    public int getFreePlaces() {
        return freePlaces;
    }
}