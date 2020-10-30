package ch.vino.cinema;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.addFilm.AddFilmController;
import ch.vino.cinema.addPresentation.AddPresentationController;
import ch.vino.cinema.addRoom.AddRoomController;
import ch.vino.cinema.code.Cinema;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Presentation;
import ch.vino.cinema.deleteRoom.DeleteRoomController;
import ch.vino.cinema.reserve.ReserveController;
import ch.vino.cinema.showFilm.ShowFilmController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    private static Main instance = new Main();
    private static Cinema cinema = new Cinema();
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        load();
        Main.primaryStage = primaryStage;
        showHome();
        primaryStage.setOnCloseRequest((WindowEvent event1) -> {
            cinema.save(cinema.toJsonRoom(), cinema.toJsonMovie(), cinema.toJsonPresentation());
        });
    }

    public void load() {
        try {
            JSONParser parser = new JSONParser();

            FileReader readerRoom = new FileReader("src/ch/vino/cinema/data/rooms.json");
            JSONArray rooms = (JSONArray) parser.parse(readerRoom);

            FileReader readerFilm = new FileReader("src/ch/vino/cinema/data/films.json");
            JSONArray films = (JSONArray) parser.parse(readerFilm);

            FileReader readerPresentation = new FileReader("src/ch/vino/cinema/data/presentations.json");
            JSONArray presentations = (JSONArray) parser.parse(readerPresentation);


            cinema.fromJSON(rooms, films, presentations);
        } catch (IOException e) {
            System.out.println("I/O Error");
        } catch (ParseException e) {
            System.out.println("Parse Error");
        }
    }


    public void showHome() throws IOException {
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

    public void showAddPresentation() throws IOException {
        FXMLLoader loader = new FXMLLoader(AddPresentationController.class.getResource("addPresentation.fxml"));
        Parent root = loader.load();
        AddPresentationController controller = loader.getController();
        Stage primaryStage = new Stage();
        controller.init(primaryStage);
        primaryStage.setTitle("Add Presentation");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showAddRoom() throws IOException {
        FXMLLoader loader = new FXMLLoader(AddRoomController.class.getResource("addRoom.fxml"));
        Parent root = loader.load();
        AddRoomController controller = loader.getController();
        Stage primaryStage = new Stage();
        controller.init(primaryStage);
        primaryStage.setTitle("Add Room");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showDeleteRoom() throws IOException {
        FXMLLoader loader = new FXMLLoader(DeleteRoomController.class.getResource("deleteRoom.fxml"));
        Parent root = loader.load();
        DeleteRoomController controller = loader.getController();
        Stage primaryStage = new Stage();
        controller.init();
        primaryStage.setTitle("Delete Room");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showAddFilm() throws IOException {
        FXMLLoader loader = new FXMLLoader(AddFilmController.class.getResource("addFilm.fxml"));
        Parent root = loader.load();
        AddFilmController controller = loader.getController();
        Stage primaryStage = new Stage();
        controller.init(primaryStage);
        primaryStage.setTitle("Add Film");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static Cinema getCinema() {
        return cinema;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance(){
        return instance;
    }
}
