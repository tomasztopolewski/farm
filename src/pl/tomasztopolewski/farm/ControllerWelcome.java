package pl.tomasztopolewski.farm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

import static pl.tomasztopolewski.farm.Main.*;

public class ControllerWelcome implements Initializable {

    @FXML
    Label labelTitle;

    @FXML
    Label labelLoadingText;

    @FXML
    Label labelFooter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setText(new String(NAME).toUpperCase());
        labelFooter.setText(NAME + " v" + VERSION + " " + TYPE_VERSION + " by " + AUTHOR);
    }

    public void setPaneWelcome() {
        //.setPrefSize(WIDTH_MAIN, HEIGHT_MAIN);
    }

    public void setLabelTitle() {
        labelTitle.setText(new String(NAME).toUpperCase());
        labelTitle.setPrefSize(1000.0, 140.0);
        labelTitle.setLayoutX(0); labelTitle.setLayoutY(190.0);
        labelTitle.setFont(new Font(150));
        labelTitle.setAlignment(Pos.CENTER);
    }


}
