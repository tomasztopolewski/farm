package pl.tomasztopolewski.farm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static pl.tomasztopolewski.farm.Main.*;

public class ControllerCriticalError implements Initializable {

    @FXML
    Label versionL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        versionL.setText(NAME + " v" + VERSION + " " + TYPE_VERSION);
    }
}
