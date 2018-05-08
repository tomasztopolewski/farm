package pl.tomasztopolewski.farm.preparation;

import pl.tomasztopolewski.farm.Logs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Installation {
    public final static String pathToFolder = "C:\\Program Files\\Farm\\";
    public final static String pathToFileLogs = "bin\\logs.logs";
    public final static String pathToFileSettings = "bin\\settings.farmfile";

    public Installation() {};

    public boolean installation() throws IOException {
        if (checkingFileSetting()) {
            new Logs(Logs.SYSTEM_INFO + "Sprawdzono strukturę plików. Stan: poprawna.");
            return true;
        } else {
            createFiles();
            return installation();
        }
    }

    private boolean checkingFileSetting() {
        return  new File(pathToFolder + pathToFileSettings).canRead()
                && new File(pathToFolder + pathToFileSettings).canWrite();

        /* return new File(pathToFolder + "bin\\settings.farmfile").canRead()
                && new File(pathToFolder + "bin\\settings.farmfile").canWrite()

                && new File(pathToFolder + "bin\\logs.logs").canRead()
                && new File(pathToFolder + "bin\\logs.logs").canWrite()

                && new File(pathToFolder + "0.txt").canRead()
                && new File(pathToFolder + "0.txt").canWrite()  ? true : false; */
    }

    private boolean checkingFileLogs() {
        return  new File(pathToFolder + pathToFileLogs).canRead()
                && new File(pathToFolder + pathToFileLogs).canWrite();
    }


    private void createFiles() throws IOException {
        // tworzenie plików
        Files.createDirectory(Paths.get(pathToFolder + "bin"));
        new File(pathToFolder + pathToFileSettings).createNewFile();
        new File(pathToFolder + pathToFileLogs).createNewFile();
        new Logs(Logs.SYSTEM_ERROR + "Brak poprawnej struktury plików.");
        new Logs(Logs.SYSTEM_INFO + "Wygenerowano nową strukturę plików.");
    }
}
