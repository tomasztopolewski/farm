package pl.tomasztopolewski.farm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.tomasztopolewski.farm.preparation.Installation;
import pl.tomasztopolewski.farm.preparation.Player;
import pl.tomasztopolewski.farm.preparation.Settings;
import java.io.IOException;

public class Main extends Application {
    public static final String NAME = "Farm";
    public static final String AUTHOR = "Tomasz Topolewski";
    public static final String VERSION = "0.00.720.0";
    public static final String TYPE_VERSION = "pre-DEV";

    public final static double WIDTH_MAIN = 1000.0, HEIGHT_MAIN = 700.0;

    Scene scene;

    Parent rootWelcome, rootCriticalError;

    Settings settings;
    Player player;

    public static void main(String[] args) throws IOException {
        launch(args);
        new Logs().appendWithVersion("Aplikacja została wyłączona.");
        new Logs(Logs.SYSTEM_WARN + "Nastąpiło wyłączenie aplikacji.");
        new Logs().appendEmptyLine();
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        if (new Installation().installation()) {
            new Logs(Logs.SYSTEM_INFO + "Instalacja została sprawdzona. Stan: poprawny.");
            new Logs(Logs.SYSTEM_INFO + "Ładowanie widoku aplikacji.");

            rootWelcome = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
            setScene(new Scene(rootWelcome, WIDTH_MAIN, HEIGHT_MAIN));

            new Logs().appendWithVersion("Wczytuję ustawienia.");
            settings = new Settings();
            new Logs().appendWithVersion("Ładuję ustawienia i pliki gracza.");
            player = new Player(settings.getValuesFromSettings());

        } else {
            rootCriticalError = FXMLLoader.load(getClass().getResource("CriticalError.fxml"));
            setScene(new Scene(rootCriticalError, WIDTH_MAIN, HEIGHT_MAIN));
        }

        stage.setTitle(NAME + " v" + VERSION + " " + TYPE_VERSION);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
