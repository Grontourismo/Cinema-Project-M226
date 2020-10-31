package ch.vino.cinema.code;

import ch.vino.cinema.Main;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Room {
    private int idx;
    private String name;
    private int rows;
    private int seatsPerRow;
    private ArrayList<String> seats = new ArrayList<>();

    /**
     * Initialize a new Room
     *
     * @param name        name of the room
     * @param rows        count of rows in the room
     * @param seatsPerRow count of seatsPerRow in the room
     * @param idx         idx of the room
     */
    public Room(String name, int rows, int seatsPerRow, int idx) {
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.generateSeats(rows, seatsPerRow);
        this.idx = idx;
    }

    /**
     * generate seats in the room
     *
     * @param rows        count of rows
     * @param seatsPerRow count of seatsPerRow
     */
    public void generateSeats(int rows, int seatsPerRow) {
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            alphabet.add(c);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= seatsPerRow; j++) {
                seats.add(alphabet.get(i) + "" + j);
            }
        }
    }

    /**
     * create Rooms from JSONObject
     *
     * @param jsonRoom JSONObject with rooms
     * @return new Room from JSONObject
     */
    public static Room fromJSON(JSONObject jsonRoom) {
        String name = (String) jsonRoom.get("name");
        int rows = (int) (long) jsonRoom.get("rows");
        int placesPerRow = (int) (long) jsonRoom.get("ppr");
        return new Room(name, rows, placesPerRow, Main.getCinema().getRooms().size());
    }

    /**
     * get room nam
     *
     * @return room name
     */
    public String getName() {
        return name;
    }

    /**
     * get count of room rows
     *
     * @return count of room rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * get seats in room
     *
     * @return ArrayList of seats in the room
     */
    public ArrayList<String> getSeats() {
        return seats;
    }

    /**
     * get count of room seatsPerRow
     *
     * @return count of seatsPerWor in the room
     */
    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    /**
     * get room Idx
     *
     * @return room Idx
     */
    public int getIdx() {
        return idx;
    }
}
