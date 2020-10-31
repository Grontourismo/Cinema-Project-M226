package ch.vino.cinema.deleteRoom;

import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Room;
import ch.vino.cinema.prefaps.films.FilmsController;
import ch.vino.cinema.prefaps.rooms.RoomController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteRoomController {
    public VBox vbox;
    public static DeleteRoomController instance;

    /**
     * constructor
     */
    public DeleteRoomController(){
        instance = this;
    }

    /**
     * load rooms
     */
    public void init(){
        vbox.getChildren().clear();
        for(Room room : Main.getCinema().getRooms()){
            try {
                FXMLLoader loader = new FXMLLoader(RoomController.class.getResource("room2.fxml"));
                Parent root = loader.load();
                RoomController controller = loader.getController();
                controller.init(room);
                vbox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
