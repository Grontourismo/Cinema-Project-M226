package ch.vino.cinema.code;

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
        this.generateSeats(rows, seatsPerRow);
    }

    public void generateSeats(int rows, int seatsPerRow){
        ArrayList<Character> alphabet = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; ++c) {
            alphabet.add(c);
        }

        for (int i = 0; i < rows; i++){
            for (int j = 1; j <= seatsPerRow; j++){
                seats.add(alphabet.get(i) + "" + j);
            }
        }
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
