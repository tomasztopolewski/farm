package pl.tomasztopolewski.farm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pl.tomasztopolewski.farm.preparation.Installation;
import pl.tomasztopolewski.farm.preparation.Player;
import pl.tomasztopolewski.farm.preparation.Settings;
import java.io.IOException;

public class Main extends Application {
    public static final String NAME = "Farm";
    public static final String AUTHOR = "Tomasz Topolewski";
    public static final String VERSION = "0.00.730.0";
    public static final String TYPE_VERSION = "pre-DEV";

    public final static double WIDTH_MAIN = 1000.0, HEIGHT_MAIN = 700.0;

    Scene scene;

    Parent rootWelcome, rootCriticalError;

    Settings settings;
    Player player;


    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        if (new Installation().installation()) {
            new Logs(Logs.SYSTEM_INFO + "Instalacja została sprawdzona. Stan: poprawny.");
            new Logs(Logs.SYSTEM_INFO + "Ładowanie widoku aplikacji.");

            rootWelcome = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            setScene(new Scene(rootWelcome, WIDTH_MAIN, HEIGHT_MAIN));
            createLayoutWelcome();
            setScene(sceneWelcome);

            stage.setTitle(NAME + " v" + VERSION + " " + TYPE_VERSION);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();

            new Logs().appendWithVersion("Wczytuję ustawienia.");
            labelLoadingText.setText("Wczytuję ustawienia...");
            settings = new Settings();

            new Logs().appendWithVersion("Ładuję ustawienia i pliki gracza.");
            labelLoadingText.setText("Ładuję ustawienia i pliki gracza...");
            player = new Player(settings.getValuesFromSettings());

        } else {
            rootCriticalError = FXMLLoader.load(getClass().getResource("CriticalError.fxml"));
            setScene(new Scene(rootCriticalError, WIDTH_MAIN, HEIGHT_MAIN));

            stage.setTitle(NAME + " v" + VERSION + " " + TYPE_VERSION);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
        new Logs().appendWithVersion("Aplikacja została wyłączona.");
        new Logs(Logs.SYSTEM_WARN + "Nastąpiło wyłączenie aplikacji.");
        new Logs().appendEmptyLine();
    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }


    private Scene sceneWelcome;
    private Pane paneWelcome;
    private Label labelTitle, labelLoadingText, labelFooter;

    private void createLayoutWelcome() {
        paneWelcome = new Pane();
        paneWelcome.setPrefSize(WIDTH_MAIN, HEIGHT_MAIN);

        labelTitle = new Label(new String(NAME).toUpperCase());
        labelTitle.setPrefSize(1000.0, 140.0);
        labelTitle.setLayoutX(0); labelTitle.setLayoutY(190.0);
        labelTitle.setFont(new Font("System Bold", 150));
        labelTitle.setAlignment(Pos.CENTER);

        labelLoadingText = new Label("Ładowanie aplikacji...");
        labelLoadingText.setPrefSize(1000.0, 60.0);
        labelLoadingText.setLayoutX(0); labelLoadingText.setLayoutY(420.0);
        labelLoadingText.setFont(new Font("System Italic", 16));
        labelLoadingText.setAlignment(Pos.CENTER);

        labelFooter = new Label(NAME + " v" + VERSION + " " + TYPE_VERSION + " by " + AUTHOR);
        labelFooter.setPrefSize(1000.0, 60.0);
        labelFooter.setLayoutX(0); labelFooter.setLayoutY(600.0);
        labelFooter.setFont(new Font(12)); labelFooter.setTextFill(Color.rgb(163, 163, 163));
        labelFooter.setAlignment(Pos.CENTER);

        paneWelcome.getChildren().addAll(labelTitle, labelLoadingText, labelFooter);

        sceneWelcome = new Scene(paneWelcome, WIDTH_MAIN, HEIGHT_MAIN);
    }
}
