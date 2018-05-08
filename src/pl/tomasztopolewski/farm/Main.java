package pl.tomasztopolewski.farm;

import pl.tomasztopolewski.farm.preparation.Installation;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (new Installation().installation()) {
            new Logs(Logs.SYSTEM_INFO + "Instalacja została sprawdzona. Stan: poprawny.");
            new Logs(Logs.SYSTEM_INFO + "Wczytywanie pliku ustawień.");

        } else System.out.println("Krytyczny błąd aplikacji. (0x00-000");

    }
}
