package pl.tomasztopolewski.farm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static pl.tomasztopolewski.farm.Main.*;

public class ControllerMain implements Initializable {
    @FXML
    Label labelTitle;

    @FXML
    Label labelFooter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setText(NAME);
        labelFooter.setText(NAME + " v" + VERSION + " " + TYPE_VERSION + " by " + AUTHOR);
    }

}
