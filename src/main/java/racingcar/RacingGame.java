package racingcar;

import static racingcar.GameStatus.PLAYING;

import java.util.Objects;

public class RacingGame {

    private final PlayerMoveList playerMoveList;
    private final GameStatus gameStatus;

    public RacingGame(PlayerMoveList playerMoveList, GameStatus gameStatus) {
        this.playerMoveList = playerMoveList;
        this.gameStatus = gameStatus;
    }

    public static RacingGame init(PlayerMoveList playerMoveList) {
        return new RacingGame(playerMoveList, PLAYING);
    }

    public void move() {
        playerMoveList.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingGame that = (RacingGame) o;
        return Objects.equals(playerMoveList, that.playerMoveList) && gameStatus == that.gameStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMoveList, gameStatus);
    }
}
