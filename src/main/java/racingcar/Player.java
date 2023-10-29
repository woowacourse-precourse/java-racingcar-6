package racingcar;

public class Player {

    private final PlayerName playerName;
    private boolean isWinner;

    public Player(String playerName, boolean isWinner) {
        this.playerName = PlayerName.from(playerName);
        this.isWinner = isWinner;
    }

    public static Player from(String playerName) {
        return new Player(playerName, false);
    }

    public void checkWinner() {
        isWinner = true;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public boolean isWinner() {
        return isWinner;
    }
}
