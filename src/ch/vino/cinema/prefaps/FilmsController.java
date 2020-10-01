package ch.vino.cinema.prefaps;

import ch.vino.cinema.Home.ConfirmController;
import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FilmsController {
    private Movie movie;
    public Label label;
    public Button show;
    public Button delete;

    public void init(Movie movie){
        this.label.setText(movie.getName());
        this.movie = movie;
    }

    public void showPushed(){

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
