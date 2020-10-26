package ch.vino.cinema.showFilm;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Presentation;
import ch.vino.cinema.prefaps.films.FilmsController;
import ch.vino.cinema.prefaps.presentations.PresentationsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ShowFilmController {
    public static ShowFilmController instance;
    public VBox vbox;

    public ShowFilmController(){
        instance = this;
    }

    public void init(Movie movie){
        vbox.getChildren().clear();
        int nr = 0;
        HBox hbox = new HBox();
        for(Presentation presentation : Main.getCinema().getPresentationsFromMovie(movie)){
            if (nr % 3 == 0){
                hbox = new HBox();
                vbox.getChildren().add(hbox);
            }
            try {
                FXMLLoader loader = new FXMLLoader(PresentationsController.class.getResource("presentations.fxml"));
                Parent root = loader.load();
                PresentationsController controller = loader.getController();
                controller.init(presentation, movie);
                hbox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            nr++;
        }
    }

    public void back() throws IOException {
        Main.getInstance().showHome();
    }
}
