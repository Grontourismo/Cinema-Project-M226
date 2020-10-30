package ch.vino.cinema.code;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Cinema {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Presentation> presentations = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();


    /**
     * Initialize a new Room
     * @param name Name of Room
     * @param rows The count of rows
     * @param seatsPerRow The count of seats per row
     */
    public void newRoom(String name, int rows, int seatsPerRow){
        rooms.add(new Room(name, rows, seatsPerRow, rooms.size()));
    }

    /**
     * Deletes a room
     * @param room Room which should be removed
     */
    public void removeRoom(Room room){
        for (Presentation presentation : getPresentationsWithRoom(room)){
            this.presentations.remove(presentation);
        }
        this.rooms.remove(room);
    }

    /**
     * Initializes a new Presentation
     * @param movie Movie from presentation
     * @param date Date which the presentation should be playing
     * @param time Time which the presentation should be playing
     * @param room Room from presentation
     */
    public void newPresentation(Movie movie, String date, String time, Room room){
        presentations.add(new Presentation(movie, date, time, room));
    }

    /**
     * Deletes a Presentation
     * @param presentation Presentation which should be removed
     */
    public void removePresentation(Presentation presentation){
        this.presentations.remove(presentation);
    }

    /*
    public boolean isRoomBookedAtTime(Room room, String date, String time){
        boolean bool = false;
        ArrayList<Presentation> presentations = new ArrayList<>();
        presentations = this.getPresentationsByTime();
        return bool;
    }

    public ArrayList<Presentation> getPresentationsByTime(String date, String time){
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if ()
        }
    }
    */

    /**
     * Initializes a new Movie
     * @param name Name of movie
     * @param fsk Fsk of Movie
     * @param price Price from movie
     * @param genre Genre from movie
     * @param length Playing length from Movie
     */
    public void newMovie(String name, int fsk, double price, String genre, int length){
        movies.add(new Movie(name, fsk, price, genre, length, movies.size()));
    }

    /**
     * Deletes a movie
     * @param movie Movie which should be removed
     */
    public void removeMovie(Movie movie){
        for (Presentation presentation : getPresentationsFromMovie(movie)){
            this.presentations.remove(presentation);
        }
        this.movies.remove(movie);
    }

    /**
     * Gets all presentations from a Movie
     * @param movie Movie in which the presentations should be searched
     * @return ArrayList with all presentations from a movie
     */
    public ArrayList<Presentation> getPresentationsFromMovie(Movie movie){
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if (presentation.getMovie() == movie){
                presentations.add(presentation);
            }
        }
        return presentations;
    }

    /**
     * Gets all Presentations which have a room
     * @param room Room in which the presentations should be searched
     * @return Arraylist with all the presentations from a room
     */
    public ArrayList<Presentation> getPresentationsWithRoom(Room room){
        ArrayList<Presentation> presentations = new ArrayList<>();
        for (Presentation presentation : this.presentations){
            if (presentation.getRoom() == room){
                presentations.add(presentation);
            }
        }
        return presentations;
    }

    /**
     * Calls method in Presentation which makes a new reservation
     * @param seatIdx
     * @param presentation
     */
    public void addReservation(HashSet<Integer> seatIdx, Presentation presentation){
        int nr = 0;
        for (Presentation presentation1 : this.presentations){
            if (presentation1 == presentation){
                presentations.get(nr).reserveSeats(seatIdx);
            }
            nr++;
        }
    }

    /**
     * gets all rooms
     * @return arraylist with rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * gets all Presentations
     * @return arraylist with presentations
     */
    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    /**
     * gets all movies
     * @return Arraylist with movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * makes a Room jsonArray
     * @return JSONArray
     */
    public JSONArray toJsonRoom() {
        JSONArray roomArray = new JSONArray();

        for (Room room : this.rooms) {
            JSONObject roomObject = new JSONObject();
            roomObject.put("name", room.getName());
            roomObject.put("rows", room.getRows());
            roomObject.put("ppr", room.getSeatsPerRow());
            roomObject.put("seats", room.getSeats());

            roomArray.add(roomObject);
        }
        return roomArray;
    }

    /**
     * makes a Movie jsonArray
     * @return JsonArray
     */
    public JSONArray toJsonMovie() {
        JSONArray filmArray = new JSONArray();

        for (Movie movie : this.movies) {
            JSONObject filmObject = new JSONObject();
            filmObject.put("filmname", movie.getName());
            filmObject.put("fsk", movie.getFsk());
            filmObject.put("price", movie.getPrice());
            filmObject.put("genre", movie.getGenre());
            filmObject.put("length", movie.getLength());

            filmArray.add(filmObject);
        }
        return filmArray;
    }

    /**
     * makes a Presentation jsonArray
     * @return JSonArray
     */
    public JSONArray toJsonPresentation() {
        JSONArray presentationArray = new JSONArray();

        for (Presentation presentation : this.presentations) {
            JSONObject presentationObject = new JSONObject();
            presentationObject.put("film", presentation.getMovie().getIdx());
            presentationObject.put("date", presentation.getDate());
            presentationObject.put("time", presentation.getTime());
            presentationObject.put("room", presentation.getRoom().getIdx());
            presentationObject.put("freePlaces", presentation.getFreePlaces());
            presentationObject.put("roomSeats", presentation.getSeats());

            presentationArray.add(presentationObject);
        }
        return presentationArray;
    }

    /**
     * saves all JsonArray in a Json-file
     * @param roomArray Jsonarray with Room object
     * @param movieArray JsonArray with movie object
     * @param presentationArray JsonArray with presentation object
     */
    public void save(JSONArray roomArray, JSONArray movieArray, JSONArray presentationArray) {
        try (FileWriter file = new FileWriter("src/ch/vino/cinema/data/rooms.json")) {
            file.write(roomArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("src/ch/vino/cinema/data/films.json")) {
            file.write(movieArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter("src/ch/vino/cinema/data/presentations.json")) {
            file.write(presentationArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * gets all objects from all JSONArrays
     * @param rooms JsonArray with Room object
     * @param movies JsonArray with movie object
     * @param presentations JsonArray with presentation object
     */
    public void fromJSON(JSONArray rooms, JSONArray movies, JSONArray presentations) {
        ArrayList<Room> room = new ArrayList<>();
        for (Object jsonRoom : rooms) {
            room.add(Room.fromJSON((JSONObject) jsonRoom));
        }
        this.rooms = room;


        ArrayList<Movie> movie = new ArrayList<>();
        for (Object jsonFilm : movies) {

            movie.add(Movie.fromJSON((JSONObject) jsonFilm));
        }
        this.movies = movie;


        ArrayList<Presentation> presentation = new ArrayList<>();
        for (Object jsonPresentation : presentations) {

            presentation.add(Presentation.fromJSON((JSONObject) jsonPresentation));
        }
        this.presentations = presentation;
    }
}