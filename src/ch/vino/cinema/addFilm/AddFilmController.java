package ch.vino.cinema.addFilm;

import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
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

    /**
     * start method
     * @param primaryStage stage
     */
    public void init(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * on click submit add film
     */
    public void submit() {
        try {
            if (!name.getText().isEmpty() && !fsk.getText().isEmpty() && !price.getText().isEmpty() && !genre.getText().isEmpty() && !lenght.getText().isEmpty()) {
                Main.getCinema().newMovie(name.getText(), Integer.parseInt(fsk.getText()), Double.parseDouble(price.getText()), genre.getText(), Integer.parseInt(lenght.getText()));
                this.primaryStage.close();
                HomeController.instance.init();
                label.setText("");
            } else {
                label.setText("Not all Parameters set");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Values");
        }
    }
}
