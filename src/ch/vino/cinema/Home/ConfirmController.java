package ch.vino.cinema.Home;

import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmController {
    private Movie movie;
    private Stage primaryStage;

    public void init(Movie movie, Stage primaryStage){
        this.movie = movie;
        this.primaryStage = primaryStage;
    }
 
    public void cancel() {
        primaryStage.close();
    }

    public void delete() throws IOException {
        Main.getCinema().removeMovie(movie);
        HomeController.instance.init();
        primaryStage.close();
    }
}
