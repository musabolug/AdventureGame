package Game;

import java.util.Scanner;

public abstract class Location {
    private  Player player;
    String locationType;
    public static Scanner input = new Scanner(System.in);
    public Location(Player player, String locationType){
        this.player = player;
        this.locationType = locationType;
    }

    abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }


}
