package ch.vino.cinema;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.code.Cinema;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main instance = new Main();
    private static Cinema cinema = new Cinema();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("home.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.init();
        primaryStage.setTitle("ch/vino/cinema/Home");
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
