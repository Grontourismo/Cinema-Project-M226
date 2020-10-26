package ch.vino.cinema;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.code.Cinema;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Presentation;
import ch.vino.cinema.reserve.ReserveController;
import ch.vino.cinema.showFilm.ShowFilmController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Main instance = new Main();
    private static Cinema cinema = new Cinema();
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.init();
        Main.primaryStage.setTitle("Home");
        Main.primaryStage.setScene(new Scene(root));
        Main.primaryStage.show();
    }


    public void showFilm(Movie movie) throws IOException {
        FXMLLoader loader = new FXMLLoader(ShowFilmController.class.getResource("showFilm.fxml"));
        Parent root = loader.load();
        ShowFilmController controller = loader.getController();
        controller.init(movie);
        primaryStage.setTitle(movie.getName());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showPresentation(Presentation presentation, Movie movie) throws IOException {
        FXMLLoader loader = new FXMLLoader(ReserveController.class.getResource("reserve.fxml"));
        Parent root = loader.load();
        ReserveController controller = loader.getController();
        controller.init(presentation, movie);
        primaryStage.setTitle(presentation.getDate() + " | " + presentation.getTime());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static Cinema getCinema() {
        return cinema;
    }

    public static void main(String[] args) {
        cinema.autoMovies();
        launch(args);
    }

    public static Main getInstance(){
        return instance;
    }
}
