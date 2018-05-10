package pl.tomasztopolewski.farm;

import pl.tomasztopolewski.farm.preparation.Player;
import pl.tomasztopolewski.farm.preparation.Settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestingMain {

    /*8 maj 2018 23:44
    public static void main(String[] args) throws IOException {
        System.out.println("Test");
        new File("C:\\Program Files\\Farm\\ja.txt").createNewFile();
        //System.out.println("Czy plik \"ja.txt\" istnieje? " + new File("ja.txt").exists());
    }*/

    public static void main(String[] args) throws FileNotFoundException {
        //Settings settings = new Settings();
        String[] tab = new String[]{"player1", "00000" ,"00000", "0" , "0"};
        Player player = new Player(tab);

//        if (player.getSaveDownloaded().length > 0) {
            System.out.println(player.getSaveDownloaded()[0]);
            System.out.println(player.getSaveDownloaded()[1]);
        //}
    }
}
