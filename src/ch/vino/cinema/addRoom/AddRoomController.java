package ch.vino.cinema.addRoom;

import ch.vino.cinema.Main;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRoomController {
    public TextField name;
    public TextField spr;
    public TextField rows;
    public Stage primaryStage;
    public Label label;

    /**
     * start method
     * @param primaryStage stage
     */
    public void init(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * create room
     */
    public void submit() {
        if (!this.name.getText().isEmpty() && !this.spr.getText().isEmpty() && !this.rows.getText().isEmpty()) {
            try {
                String name = this.name.getText();
                int spr = Integer.parseInt(this.spr.getText());
                int rows = Integer.parseInt(this.rows.getText());
                Main.getCinema().newRoom(name, rows, spr);
                this.primaryStage.close();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Values");
            }
        } else {
            this.label.setText("Not all parameters are set");
        }
    }
}
