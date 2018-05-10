package pl.tomasztopolewski.farm.preparation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Settings {
    private boolean loaded;
    private String firstLine;
    private String secondLine;

    private String[] valuesFromSettings;

    public Settings() throws FileNotFoundException {
        loadFileSettings();
        processLines();
    }

    public String[] getValuesFromSettings() {
        return valuesFromSettings;
    }

    public void loadFileSettings() throws FileNotFoundException, NoSuchElementException {
        try {
            File fileDownload = new File(Installation.pathToFolder + Installation.nameOFFileSettings);
            Scanner reader = new Scanner(fileDownload);

            String line1 = reader.nextLine(), line2 = reader.nextLine();
            if (line1 != "" && line1 != null && line2 != "" && line2 != null) {
                this.firstLine = line1;
                this.secondLine = line2;
                loaded = true;
            } else {
                firstLine = null;
                secondLine = null;
                loaded = false;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException");
            loaded = false;
            firstLine = null;
            secondLine = null;
        }
    }

    public void processLines() {
        if (loaded) {
            String[] valuesFromFirstLine = firstLine.split(Pattern.quote(":"));
            String[] valuesFromSecondLine = secondLine.split(Pattern.quote(":"));
            String[] valuesOfArgumentsFromSecondLine = valuesFromSecondLine[1].split(Pattern.quote(";"));

            valuesFromSettings = new String[]{valuesFromFirstLine[0], valuesFromFirstLine[1], valuesFromSecondLine[0],valuesOfArgumentsFromSecondLine[0], valuesOfArgumentsFromSecondLine[1]};
        } else System.out.println("Plik " + Installation.pathToFolder + Installation.nameOFFileSettings + " nie został poprawnie załadowany.");
    }
}
