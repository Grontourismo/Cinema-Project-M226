package ch.vino.cinema.prefaps.films;

import ch.vino.cinema.Home.ConfirmController;
import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.addPresentation.AddPresentationController;
import ch.vino.cinema.code.Movie;
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

public class FilmsController {
    public Pane pane;
    public Label label2;
    public Movie movie;
    public Label label;
    public Button show;
    public Button delete;
    public boolean isChoosen;

    /**
     * start method create prefab
     * @param movie movie
     */
    public void init(Movie movie){
        pane.setStyle("-fx-border-color: black");
        this.label.setText(movie.getName());
        this.label2.setText(movie.getFilmDescription());
        this.movie = movie;
    }

    /**
     * show movie on click
     * @throws IOException exception on error
     */
    public void showPushed() throws IOException {
        Main.getInstance().showFilm(movie);
    }

    /**
     * delete when clicked
     * @throws IOException exception on error
     */
    public void deletePushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(ConfirmController.class.getResource("confirm.fxml"));
        Parent root = loader.load();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("confirm");
        primaryStage.setScene(new Scene(root));
        ((ConfirmController)  loader.getController()).init(movie, primaryStage);
        primaryStage.show();
    }

    /**
     * choose film
     */
    public void choose() {
        if (isChoosen){
            isChoosen = false;
            pane.setStyle("-fx-border-color: black");
        }else {
            for (FilmsController controller : AddPresentationController.movieControllers) {
                if (controller.isChoosen) {
                    return;
                }
            }
            this.pane.setStyle("-fx-background-color: #c9c6c3;-fx-border-color: black");
            isChoosen = true;
        }
    }
}
