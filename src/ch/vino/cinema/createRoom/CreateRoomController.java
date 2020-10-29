package ch.vino.cinema.createRoom;

import ch.vino.cinema.code.Cinema;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateRoomController {

    private Cinema cinema;
    private Stage primaryStage;
    public TextField roomName;
    public TextField numberOfRows;
    public TextField seatsPerRow;
    public Button submit;

    public void init(Cinema cinema, Stage primaryStage) {
        this.cinema = cinema;
        this.primaryStage = primaryStage;
    }

    public void submitPushed() {
        String name = roomName.getText();
        int rows = Integer.parseInt(numberOfRows.getText());
        int seatsPerRow2 = Integer.parseInt(seatsPerRow.getText());
        cinema.newRoom(name, rows, seatsPerRow2);
        primaryStage.close();
    }
}
