package ch.vino.cinema.createMovie;

import ch.vino.cinema.code.Cinema;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateMovieController {
    Cinema cinema;
    Stage primaryStage;

    public TextField name;
    public TextField fsk;
    public TextField price;
    public TextField genre;
    public TextField length;

    public void init(Cinema cinema, Stage primaryStage) {
        this.cinema = cinema;
        this.primaryStage = primaryStage;
    }

    public void submitPushed(ActionEvent event) {
        String name = this.name.getText();
        int fsk = Integer.parseInt(this.fsk.getText());
        double price = Double.parseDouble(this.price.getText());
        String genre = this.genre.getText();
        int length = Integer.parseInt(this.length.getText());
        cinema.newMovie(name, fsk, price, genre, length);
        primaryStage.close();
    }
}
