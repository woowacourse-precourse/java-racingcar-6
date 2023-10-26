package player;

public class Player {
    int dist = 0;
    private final String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDist() {
        return dist;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) this.dist++;
    }
}
