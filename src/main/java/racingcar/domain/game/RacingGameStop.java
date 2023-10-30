package racingcar.domain.game;

public class RacingGameStop {
    private int attemptCount;
    private GameStatus gameStatus;

    private RacingGameStop(int attemptCount) {
        this.attemptCount = attemptCount;
        this.gameStatus = GameStatus.RUN;
    }

    public static RacingGameStop init(int attemptCount) {
        return new RacingGameStop(attemptCount);
    }

    public GameStatus isRunning() {
        this.attemptCount -= 1;
        if(this.attemptCount == 0) {
            gameStatus = GameStatus.STOP;
        }
        return gameStatus;
    }
}
