package pl.tomasztopolewski.farm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import pl.tomasztopolewski.farm.app.ControllerMain;

import java.io.IOException;

public class Main extends Application {
    public static final String NAME = "Farm";
    public static final String AUTHOR = "Tomasz Topolewski";
    public static final String VERSION = "0.00.100";
    public static final String TYPE_VERSION = "PRE-DEV";

    public final static double HEIGHT_MAIN = 400.0, WIDTH_MAIN = 600.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle(NAME);
        primaryStage.setScene(new Scene(root, WIDTH_MAIN, HEIGHT_MAIN));
        primaryStage.show();
    }
}
