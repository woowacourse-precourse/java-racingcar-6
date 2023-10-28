package racingcar;

public class Player {

    private final PlayerName playerName;

    public Player(String playerName) {
        this.playerName = PlayerName.from(playerName);
    }

    public static Player from(String playerName) {
        return new Player(playerName);
    }
}
