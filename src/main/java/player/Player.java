package player;

public class Player {
    private int distance = 0;
    private final String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDist() {
        return distance;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.distance++;
        }
    }
}
