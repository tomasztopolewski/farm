/**
 * Klasa 'Installation' odpowiada za poprawną instalację gry.
 *
 * Wersje klasy:
 *    v1.0:
 *    - proste ustawienia gry przechowujące dane o jednym graczu
 *    - zapisywanie kominukatów (logów) systemowych do pliku
 *
 *    v2.0:
 *    - wczytywanie wielu graczy
 *
 */
package pl.tomasztopolewski.farm.preparation;

import javafx.scene.shape.Path;
import pl.tomasztopolewski.farm.Logs;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Installation {
    public final static String pathToFolder = "C:\\Program Files\\Farm\\bin\\";
    public final static String nameOFFileSettings = "settings.farmfile";
    //public final static String nameOFFilePlayers = "players.farmfile";
    public final static String nameOfFileLogs = "logs.logs";

    public Installation() {};

    public boolean installation() throws IOException {
        //if (Paths.get(pathToFolder).
        if (checkingFileSetting() && checkingFileLogs()) {
            return true;
        } else {
            createDirectories();
            createFileLogs();
            createFileSetting();
        }
        new Logs(Logs.SYSTEM_WARN + "Ponowne sprawdzenie struktury plików.");
        return installation();
    }

    private boolean checkingFileSetting() {
        return  new File(pathToFolder + nameOFFileSettings).canRead()
                && new File(pathToFolder + nameOFFileSettings).canWrite();

        /* return new File(pathToFolder + "bin\\settings.farmfile").canRead()
                && new File(pathToFolder + "bin\\settings.farmfile").canWrite()

                && new File(pathToFolder + "bin\\logs.logs").canRead()
                && new File(pathToFolder + "bin\\logs.logs").canWrite()

                && new File(pathToFolder + "0.txt").canRead()
                && new File(pathToFolder + "0.txt").canWrite()  ? true : false; */
    }

    private boolean checkingFileLogs() {
        return  new File(pathToFolder + nameOfFileLogs).canRead()
                && new File(pathToFolder + nameOfFileLogs).canWrite();
    }


    private void createDirectories() throws IOException {
        //Files.createDirectory(Paths.get("C:\\Program Files\\Farm"));
        //Files.createDirectory(Paths.get("C:\\Program Files\\Farm\\bin"));
        new File("C:\\Program Files\\Farm\\bin").mkdirs();
    }

    private void createFileSetting() throws IOException {
        // tworzenie plików
        //Files.createDirectory(Paths.get(pathToFolder));
        new File(pathToFolder + nameOFFileSettings).createNewFile();
        new Logs(Logs.SYSTEM_ERROR + "Nie znaleziono pliku ustawień w strukturze plików.");
        new Logs(Logs.SYSTEM_INFO + "Wygenerowano plik ustawień.");
    }

    private void createFileLogs() throws IOException {
        // tworzenie plików
        //Files.createDirectory(Paths.get(pathToFolder));
        new File(pathToFolder + nameOfFileLogs).createNewFile();
        new Logs(Logs.SYSTEM_ERROR + "Nie znaleziono pliku logów w strukturze plików.");
        new Logs(Logs.SYSTEM_INFO + "Wygenerowano plik logów.");
    }
}
