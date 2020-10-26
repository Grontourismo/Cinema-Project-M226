package ch.vino.cinema.reserve;

import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Presentation;
import ch.vino.cinema.prefaps.presentations.PresentationsController;
import ch.vino.cinema.prefaps.reserve.SeatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class ReserveController {
    public VBox vbox;
    public Presentation presentation;
    public ArrayList<SeatController> controllers = new ArrayList<>();
    public Movie movie;

    public void init(Presentation presentation, Movie movie){
        this.movie = movie;
        this.presentation = presentation;
        ArrayList<String> seats = presentation.getSeats();
        int seatsPerRow = presentation.getRoom().getSeatsPerRow();
        int nr = 0;
        HBox hbox = new HBox();
        for (String seat : seats){
            if (nr % seatsPerRow == 0) {
                hbox = new HBox();
                vbox.getChildren().add(hbox);
            }
            try {
                FXMLLoader loader = new FXMLLoader(SeatController.class.getResource("seat.fxml"));
                Parent root = loader.load();
                SeatController controller = loader.getController();
                controller.init(seat);
                controllers.add(controller);
                hbox.getChildren().add(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            nr++;
        }
    }

    public void reserve() throws IOException {
        HashSet<Integer> seatIdx = new HashSet<>();
        int nr = 0;
        for (SeatController controller : controllers){
            if (controller.isSelected()){
                seatIdx.add(nr);
            }
            nr++;
        }
        Main.getCinema().addReservation(seatIdx, presentation);
        Main.getInstance().showFilm(movie);
    }
}
