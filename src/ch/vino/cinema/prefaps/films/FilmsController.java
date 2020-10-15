package ch.vino.cinema.prefaps.films;

import ch.vino.cinema.Home.ConfirmController;
import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
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

public class FilmsController {
    public Pane pane;
    public Label label2;
    private Movie movie;
    public Label label;
    public Button show;
    public Button delete;

    public void init(Movie movie){
        pane.setStyle("-fx-border-color: black");
        this.label.setText(movie.getName());
        this.label2.setText(movie.getFilmDescription());
        this.movie = movie;
    }

    public void showPushed() throws IOException {
        Main.getInstance().showFilm(movie);
    }

    public void deletePushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(ConfirmController.class.getResource("confirm.fxml"));
        Parent root = loader.load();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("confirm");
        primaryStage.setScene(new Scene(root));
        ((ConfirmController)  loader.getController()).init(movie, primaryStage);
        primaryStage.show();
    }
}
