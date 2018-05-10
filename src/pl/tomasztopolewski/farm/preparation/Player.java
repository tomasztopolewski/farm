/**
 * Klasa 'Player' odpowiada za poprawne wczytywanie, zapisywanie danych gracza.
 *
 * Wersje klasy:
 *    v1.0:
 *    - ładowanie podstawowych informacji o graczu
 *    - wczytywanie stanu gry
 *    - zapisywanie stanu gry
 *
 * Zmienna typu String 'username' przechowuje nazwę gravza.
 * Zmienna typu String 'id' przechowuje id gracza.
 * Tablica typu String 'saveDownloaded' przechowuje dane o wynikach w grze.
 *
 */
package pl.tomasztopolewski.farm.preparation;

public class Player {
    private String username;
    private String id;
    private String[] saveDownloaded;

    public Player(String[] valuesFromSettings) {
        if (valuesFromSettings[1].equals(valuesFromSettings[2])) {
            setUsername(valuesFromSettings[0]);
            setId(valuesFromSettings[1]);
            this.saveDownloaded = prepareSaveDownloadedFromSettings(valuesFromSettings);
        }
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String[] getSaveDownloaded() {
        return saveDownloaded;
    }
    public String[] prepareSaveDownloadedFromSettings(String[] valuesFromSettings) {
        String[] saveDownloaded = new String[valuesFromSettings.length - 3];
        for (int i = 3; i < valuesFromSettings.length; i++) {
            saveDownloaded[i-3] = valuesFromSettings[i];
        }
        return saveDownloaded;
    }
}
