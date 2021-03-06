package pl.tomasztopolewski.farm;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import pl.tomasztopolewski.farm.preparation.Installation;

import static pl.tomasztopolewski.farm.Main.NAME;
import static pl.tomasztopolewski.farm.Main.TYPE_VERSION;
import static pl.tomasztopolewski.farm.Main.VERSION;

public class Logs {
    public static String pathToTheFolder;
    public static String nameFile;

    public static final String CRITICAL_ERROR = "[CRITICAL-ERROR] ",
            SYSTEM_INFO = "[SYSTEM-INFO] ", SYSTEM_WARN = "[SYSTEM-WARN] ", SYSTEM_ERROR = "[SYSTEM-ERROR] ",
            GAME_INFO = "[GAME-INFO] ", GAME_WARN = "[GAME-WARN] ",GAME_ERROR = "[GAME-ERROR] ";

    public int numerator;

    Writer logsput;

    private SimpleDateFormat dateFormating = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public Logs() throws IOException {
        String line, lastLine = "";

        BufferedReader reader = new BufferedReader(new FileReader(Installation.pathToFolder + Installation.nameOfFileLogs));
        while ((line = reader.readLine()) != null) lastLine = line;

        if (lastLine != "" && lastLine != null) {
            String[] s = lastLine.split(Pattern.quote(")"));
            if (s.length > 0) this.numerator = Integer.parseInt(s[0]);
            else this.numerator = 0;
        } else {
            this.numerator = 0;
        }
        //System.out.println("s[0]: " + s);
    }
    public Logs(String log) throws IOException {
        String line, lastLine = "";
        BufferedReader reader = new BufferedReader(new FileReader(Installation.pathToFolder + Installation.nameOfFileLogs));
        while ((line = reader.readLine()) != null) lastLine = line;

        if (lastLine != "" && lastLine != null) {
            String[] s = lastLine.split(Pattern.quote(")"));
            if (s.length > 0) this.numerator = Integer.parseInt(s[0]);
            else this.numerator = 0;
        } else {
            this.numerator = 0;
        }

        logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.nameOfFileLogs, true));
        if (numerator == 0) logsput.append(++numerator + ") [" + dateFormating.format(new Date()) + "] " + log);
        else logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + log);
        logsput.close();
    }


    public void appendWithVersion(String s) throws IOException {
        //farm_v0.00.115.2-pre-dev
        logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.nameOfFileLogs, true));
        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] [" + new String(NAME).toLowerCase() + "_v" + new String(VERSION + "-" + TYPE_VERSION).toLowerCase() + "] " + s);
        logsput.close();
    }

    public void appendEmptyLine() throws IOException {
        logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.nameOfFileLogs, true));
        logsput.append("\n");
        logsput.close();
    }

    /**
     *  Stare metody
     *
     * public void appendStart(String s) throws IOException {
     *   logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.pathToFileLogs, true));
     *   logsput.append("\n\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
     *   logsput.close();
     * }
     *
     * public void appendReason() throws IOException {
     *   logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.pathToFileLogs, true));
     *
     *   Scanner scanner = new Scanner(System.in);
     *   System.out.println("[CONSOLE] Powód uruchomienia programu: ");
     *   String s = scanner.nextLine();
     *
     *   logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
     *   logsput.close();
     * }
     *
     * public void appendWithReason(String s) throws IOException {
     *   logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.pathToFileLogs, true));
     *   logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
     *   logsput.close();
     * }
     *
     * public void appendEnd(String s) throws IOException {
     *   logsput = new BufferedWriter(new FileWriter(Installation.pathToFolder + Installation.pathToFileLogs, true));
     *   logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
     *   logsput.close();
     * }
     */
}
