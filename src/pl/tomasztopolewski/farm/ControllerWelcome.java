package pl.tomasztopolewski.farm;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.ResourceBundle;

import static pl.tomasztopolewski.farm.Main.*;

public class ControllerWelcome implements Initializable {

    @FXML
    Pane paneWelcome;

    @FXML
    public Label labelTitle;

    @FXML
    Label labelLoadingText;

    @FXML
    Label labelFooter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setText(new String(NAME).toUpperCase());
        labelFooter.setText(NAME + " v" + VERSION + " " + TYPE_VERSION + " by " + AUTHOR);
        labelLoadingText.setText("Ładowanie aplikacji...");
    }

    public void loadingText1() throws InterruptedException {
        labelLoadingText.setText("Ładowanie aplikacji...");
    }
    public void loadingText2() throws InterruptedException {
        labelLoadingText.setText("Wczytywanie ustawień...");
    }
    public void loadingText3() throws InterruptedException {
        labelLoadingText.setText("Ładuję ustawienia i pliki gracza...");
    }
    public void loadingText4() throws InterruptedException {
        labelLoadingText.setText("Uruchamianie gry...");
    }
}
