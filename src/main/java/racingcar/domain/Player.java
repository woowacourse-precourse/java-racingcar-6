package racingcar.domain;

public class Player {

    private final PlayerName playerName;
    private boolean isWinner;

    private Player(final String playerName, final boolean isWinner) {
        this.playerName = PlayerName.from(playerName);
        this.isWinner = isWinner;
    }

    public static Player from(final String playerName) {
        return new Player(playerName, false);
    }

    public static Player of(final String playerName, boolean isWinner) {
        return new Player(playerName, isWinner);
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
