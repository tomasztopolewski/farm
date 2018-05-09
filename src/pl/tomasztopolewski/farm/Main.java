package pl.tomasztopolewski.farm;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;
//import pl.tomasztopolewski.farm.app.ControllerMain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {
    public static final String NAME = "Farm";
    public static final String AUTHOR = "Tomasz Topolewski";
    public static final String VERSION = "0.00.115.2";
    public static final String TYPE_VERSION = "pre-DEV";

    public final static double  WIDTH_MAIN = 1000.0, HEIGHT_MAIN = 700.0;

    protected Scene sceneWelcome;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //createLayoutWelcome();

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle(NAME + " v" + VERSION + " " + TYPE_VERSION);
        sceneWelcome = new Scene(root, WIDTH_MAIN, HEIGHT_MAIN);
        //createLayoutWelcome();

        //ControllerMain.setLabelTitle();

        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

   /*@Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Kliknęto guzik.");
            }
        });
    }*/



    /*private void createLayoutWelcome() {
        paneWelcome = new Pane();
        paneWelcome.setPrefSize(WIDTH_MAIN, HEIGHT_MAIN);

        labelTitle = new Label(new String(NAME).toUpperCase());
        labelTitle.setPrefSize(1000.0, 140.0);
        labelTitle.setLayoutX(0); labelTitle.setLayoutY(190.0);
        labelTitle.setFont(new Font(150));
        labelTitle.setAlignment(Pos.CENTER);

        labelFooter = new Label(NAME + " v" + VERSION + " " + TYPE_VERSION + " by " + AUTHOR);
        labelFooter.setPrefSize(1000.0, 60.0);
        labelFooter.setLayoutX(0); labelFooter.setLayoutY(600.0);
        labelFooter.setFont(new Font(16));
        labelFooter.setAlignment(Pos.CENTER);

        //sceneWelcome.setRoot(paneWelcome);
        paneWelcome.getChildren().addAll(labelTitle, labelFooter);
        //sceneWelcome.setRoot(paneWelcome);
    }*/


}
