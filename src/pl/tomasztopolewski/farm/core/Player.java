package pl.tomasztopolewski.farm.core;

public class Player {
    private String username, id;

    private String[] saveDownloaded;
    private double[] saveLoaded;

    public Player(String username, String id, String[] saveDownloaded) {
        setUsername(username);
        setId(id);
        setSaveDownloaded(saveDownloaded);

    }
    public Player() {}

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
    public void setSaveDownloaded(String[] saveDownloaded) {
        this.saveDownloaded = saveDownloaded;
    }

    public double[] getSaveLoaded() {
        return saveLoaded;
    }
    public void setSaveLoaded(double[] saveLoaded) {
        this.saveLoaded = saveLoaded;
    }



}
