package racingcar;

import static racingcar.GameStatus.PLAYING;

import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final List<PlayerMove> playerMoves;
    private final GameStatus gameStatus;
    private final MoveFactory moveFactory;

    public RacingGame(List<PlayerMove> playerMoves, GameStatus gameStatus, MoveFactory moveFactory) {
        this.playerMoves = playerMoves;
        this.gameStatus = gameStatus;
        this.moveFactory = moveFactory;
    }

    public static RacingGame init(List<PlayerMove> playerMoves, MoveFactory moveFactory) {
        return new RacingGame(playerMoves, PLAYING, moveFactory);
    }

    public void move() {
        for (PlayerMove playerMove : playerMoves) {
            playerMove.move(moveFactory.isMove());
        }
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
        return Objects.equals(playerMoves, that.playerMoves) && gameStatus == that.gameStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerMoves, gameStatus);
    }
}
