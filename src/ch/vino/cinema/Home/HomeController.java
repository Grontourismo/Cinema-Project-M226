package ch.vino.cinema.Home;

import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.prefaps.films.FilmsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {
    public static HomeController instance;
    public VBox vbox;
    public Button createRoom;

    public HomeController() {
        instance = this;
    }

    public void init() {
        vbox.getChildren().clear();
        for (Movie movie : Main.getCinema().getMovies()) {
            try {
                FXMLLoader loader = new FXMLLoader(FilmsController.class.getResource("films.fxml"));
                Parent root = loader.load();
                FilmsController controller = loader.getController();
                controller.init(movie);
                vbox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createRoomPushed() throws IOException {
        Main.getInstance().createRoom();
    }

    public void createMoviePushed() throws IOException {
        Main.getInstance().createMovie();
    }
}
