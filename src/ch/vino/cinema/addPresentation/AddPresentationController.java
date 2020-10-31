package ch.vino.cinema.addPresentation;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Room;
import ch.vino.cinema.prefaps.films.FilmsController;
import ch.vino.cinema.prefaps.rooms.RoomController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddPresentationController {
    public VBox vbox;
    public static AddPresentationController instance;
    public static ArrayList<FilmsController> movieControllers = new ArrayList<>();
    public static ArrayList<RoomController> roomControllers = new ArrayList<>();
    public VBox vboxRoom;
    public TextField time;
    public DatePicker datepicker;
    public Stage primaryStage;

    /**
     * constructor
     */
    public AddPresentationController() {
        instance = this;
    }

    /**
     * start method load movies and rooms
     * @param primaryStage stage
     */
    public void init(Stage primaryStage) {
        this.primaryStage = primaryStage;
        vbox.getChildren().clear();
        for (Movie movie : Main.getCinema().getMovies()) {
            try {
                FXMLLoader loader = new FXMLLoader(FilmsController.class.getResource("films2.fxml"));
                Parent root = loader.load();
                FilmsController controller = loader.getController();
                controller.init(movie);
                movieControllers.add(controller);
                vbox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        vboxRoom.getChildren().clear();
        for (Room room : Main.getCinema().getRooms()) {
            try {
                FXMLLoader loader = new FXMLLoader(RoomController.class.getResource("room.fxml"));
                Parent root = loader.load();
                RoomController controller = loader.getController();
                controller.init(room);
                roomControllers.add(controller);
                vboxRoom.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * create new presentation
     */
    public void submit() {
        Movie movie = null;
        Room room = null;
        for (FilmsController controll : movieControllers) {
            if (controll.isChoosen) {
                movie = controll.movie;
            }
        }
        for (RoomController controll : roomControllers) {
            if (controll.isChoosen) {
                room = controll.room;
            }
        }
        try {
            String date = this.datepicker.getValue().toString();
            String time = this.time.getText();
            Main.getCinema().newPresentation(movie, date, time, room);
            HomeController.instance.init();
            this.primaryStage.close();
        } catch (NullPointerException e) {
            System.out.println("Invalid choose");
        }
    }
}
