package pl.tomasztopolewski.farm;

import javafx.stage.Stage;
import pl.tomasztopolewski.farm.preparation.Installation;
import java.io.IOException;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        if (new Installation().installation()) {
            new Logs(Logs.SYSTEM_INFO + "Instalacja została sprawdzona. Stan: poprawny.");
            new Logs(Logs.SYSTEM_INFO + "Wczytywanie pliku ustawień.");

           // pl.tomasztopolewski.farm.app.Main.start(new Stage());

        } else System.out.println("Krytyczny błąd aplikacji. (0x00-000)");

    }
}
