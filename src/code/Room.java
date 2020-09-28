package code;

import java.util.ArrayList;

public class Room {
    private String name;
    private int rows;
    private int seatsPerRow;
    private ArrayList<String> seats = new ArrayList<>();

    public Room(String name, int rows, int seatsPerRow) {
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        //test
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public ArrayList<String> getSeats() {
        return seats;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }


}