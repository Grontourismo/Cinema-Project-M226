package ch.vino.cinema.addRoom;

import ch.vino.cinema.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;

public class AddRoomController {
    public TextField name;
    public TextField spr;
    public TextField rows;
    public Stage primaryStage;
    public Label label;

    public void init(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void submit() {
        if (!this.name.getText().isEmpty() && !this.spr.getText().isEmpty() && !this.rows.getText().isEmpty()) {
            String name = this.name.getText();
            int spr = Integer.parseInt(this.spr.getText());
            int rows = Integer.parseInt(this.rows.getText());
            Main.getCinema().newRoom(name, rows, spr);
            this.primaryStage.close();
        }else {
            this.label.setText("Not all parameters are set");
        }
    }
}
