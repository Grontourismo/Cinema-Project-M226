package ch.vino.cinema.prefaps.reserve;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SeatController {
    @FXML
    private AnchorPane pane;
    @FXML
    private Label label;
    private String seatNr;
    private boolean isSelected;

    /**
     * start method create seat prefab
     *
     * @param seatNr
     */
    public void init(String seatNr) {
        pane.setStyle("-fx-border-color: black");
        this.seatNr = seatNr;
        if (seatNr.equals("XX")) {
            this.pane.setStyle("-fx-background-color: #de3a1d; -fx-border-color: black");
        }
        this.label.setText(seatNr);
    }

    /**
     * make background green on clicked
     */
    public void clicked() {
        if (!seatNr.equals("XX")) {
            this.pane.setStyle("-fx-background-color: #4ced24; -fx-border-color: black");
            this.isSelected = true;
        }
    }

    /**
     * look if selected
     *
     * @return is selected value
     */
    public boolean isSelected() {
        return isSelected;
    }
}
