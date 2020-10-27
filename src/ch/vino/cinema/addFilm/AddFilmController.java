package ch.vino.cinema.addFilm;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddFilmController {
    public TextField name;
    public TextField fsk;
    public TextField price;
    public TextField genre;
    public TextField lenght;
    public Label label;
    public Stage primaryStage;

    public void init(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void submit() {
        if (!name.getText().isEmpty() && !fsk.getText().isEmpty() && !price.getText().isEmpty() && !genre.getText().isEmpty() && !lenght.getText().isEmpty()){
            Main.getCinema().newMovie(name.getText(), Integer.parseInt(fsk.getText()), Double.parseDouble(price.getText()), genre.getText(), Integer.parseInt(lenght.getText()));
            this.primaryStage.close();
            HomeController.instance.init();
        }else{
            label.setText("Not all Parameters set");
        }
    }
}
