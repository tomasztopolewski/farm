package pl.tomasztopolewski.farm;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

import static pl.tomasztopolewski.farm.Main.*;

public class ControllerMain implements Initializable {

    @FXML
    protected Pane paneWelcome;
    @FXML
    protected Label labelTitle;
    @FXML
    protected Label labelFooter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPaneWelcome();
        setLabelTitle();
    }

    public void setPaneWelcome() {
        paneWelcome.setPrefSize(WIDTH_MAIN, HEIGHT_MAIN);
    }

    public void setLabelTitle() {
        labelTitle.setText(new String(NAME).toUpperCase());
        labelTitle.setPrefSize(1000.0, 140.0);
        labelTitle.setLayoutX(0); labelTitle.setLayoutY(190.0);
        labelTitle.setFont(new Font(150));
        labelTitle.setAlignment(Pos.CENTER);
    }

}
