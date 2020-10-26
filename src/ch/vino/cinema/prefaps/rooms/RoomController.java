package ch.vino.cinema.prefaps.rooms;

import ch.vino.cinema.Home.ConfirmController;
import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.addPresentation.AddPresentationController;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomController {
    public Pane pane;
    public Label label2;
    public Room room;
    public Label label;
    public boolean isChoosen;

    public void init(Room room){
        pane.setStyle("-fx-border-color: black");
        this.label.setText(room.getName());
        this.label2.setText("Rows: " + room.getRows() + " | Seats per row: " + room.getSeatsPerRow());
        this.room = room;
    }

    public void choose() {
        if (isChoosen){
            isChoosen = false;
            pane.setStyle("-fx-border-color: black");
        }else {
            for (RoomController controller : AddPresentationController.roomControllers) {
                if (controller.isChoosen) {
                    return;
                }
            }
            this.pane.setStyle("-fx-background-color: #c9c6c3;-fx-border-color: black");
            isChoosen = true;
        }
    }
}
