package ch.vino.cinema.prefaps.presentations;

import ch.vino.cinema.Home.ConfirmController;
import ch.vino.cinema.Home.HomeController;
import ch.vino.cinema.Main;
import ch.vino.cinema.code.Movie;
import ch.vino.cinema.code.Presentation;
import ch.vino.cinema.showFilm.ShowFilmController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PresentationsController {
    public Pane pane;
    @FXML
    private Label dateTime;
    @FXML
    private Label room;
    @FXML
    private Label freePlaces;
    private Presentation presentation;
    private Movie movie;

    /**
     * start method create prefab
     * @param presentation presentation
     * @param movie movie
     */
    public void init(Presentation presentation, Movie movie){
        pane.setStyle("-fx-border-color: black");
        this.presentation = presentation;
        this.movie = movie;
        this.dateTime.setText(presentation.getDate() + " | " + presentation.getTime());
        this.room.setText(presentation.getRoom().getName());
        this.freePlaces.setText(presentation.getFreePlaces() + "");
    }

    /**
     * reserve
     * @throws IOException exception on error
     */
    public void reserve() throws IOException {
        Main.getInstance().showPresentation(presentation, movie);
    }

    /**
     * delete
     * @throws IOException exception on error
     */
    public void delete() throws IOException {
        Main.getCinema().removePresentation(presentation);
        ShowFilmController.instance.init(movie);
    }
}
